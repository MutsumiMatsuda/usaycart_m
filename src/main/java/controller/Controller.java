package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * CSRFトークン関連機能を実装したコントローラー基底クラス
 * @author Matsuda
 *
 */
public class Controller extends HttpServlet {
  protected static final String HASHTYPE = "SHA-256";         // Hashタイプ
  protected static final String GETTOKENNAME = "csrf-token";  // CSRFトークンのヘッダーアトリビュート名
  protected static final String POSTTOKENNAME = "_token";     // CSRFトークンのセッションアトリビュート名

  /**
   * CSRFトークンをセッションに格納し、トークンを返す
   * @param rq
   * @return CSRFトークン
   */
  protected String setCsrｆ(HttpServletRequest rq) {
    
    String seed = getSeed(rq);
    System.out.println("Seed:" + seed);
    byte[] sha = getHash(seed);
    String token = bytes2Str(sha);
    System.out.println("生成トークン：" + token);
    
    // セッションにトークンを格納
    rq.getSession().setAttribute(POSTTOKENNAME, token);
    System.out.println("セッション値：" + rq.getSession().getAttribute(POSTTOKENNAME));
    return token;
  }
  
  /**
   * CSRFトークンの検証、検証済みのトークンの削除
   * @param rq
   * @return トークンの検証結果 true : ok  false : ng
   */
  protected boolean verifyToken(HttpServletRequest rq) {
    System.out.println("Http method：" + rq.getMethod());
    String token = "GET".equals(rq.getMethod()) ? rq.getHeader(GETTOKENNAME) : rq.getParameter(POSTTOKENNAME);
    HttpSession ses = rq.getSession();
    String csrf = (String)ses.getAttribute(POSTTOKENNAME);
    ses.removeAttribute(POSTTOKENNAME);
    return (null != token) && (null != csrf) && csrf.equals(token);
  }

  /**
   * CSRFトークン精製用のシートを返す
   * @param rq リクエスト
   * @return CSRFトークン精製用のシート
   */
  protected static String getSeed(HttpServletRequest rq) {
    
    Timestamp now = new Timestamp(System.currentTimeMillis());
    return rq.getRemoteAddr() + now.toString();
  }

  /**
   * CSRF用ハッシュ値を返す
   * @param seed
   * @return
   */
  protected static byte [] getHash(String seed) {
    
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance(HASHTYPE);
    } catch (NoSuchAlgorithmException e) {
      // TODO 自動生成された catch ブロック
      e.printStackTrace();
    }
    return md.digest(seed.getBytes());
  }

  /**
   * byte配列をStringに変換
   * @param ary
   * @return Stringに変換されたbyte配列
   */
  protected static String bytes2Str(byte [] ary) {
    
    StringBuffer buf = new StringBuffer();
    for(byte b : ary) {
      // 値の符号を反転させ、16進数に変換
      String tmp = Integer.toHexString(0xff & b);

      if(1 == tmp.length()) {
        // 値が一桁だった場合、先頭に0を追加し、バッファに追加
        buf.append('0').append(tmp);
      } else {
        // その他の場合、バッファに追加
        buf.append(tmp);
      }
    }

    // 完了したハッシュ計算値を返却
    return buf.toString();
  }
}

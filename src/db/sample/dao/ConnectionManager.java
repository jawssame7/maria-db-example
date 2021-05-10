package db.sample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * <pre>
 * ConnectionManager
 * コネクションプールクラス
 * </pre>
 * @version 1.0.0
 */
public class ConnectionManager {

	/** サーバーのIP(サーバー名) */
	private static final String DB_SERVER_IP = "127.0.0.1";

	/** ポート番号 */
	private static final String PORT_NO = "3306";

	/** DB名 */
	private static final String DB_NAME = "test";

	/** ユーザ名 */
	private static final String USER_ID = "root";

	/** パスワード */
	private static final String PASSWORD = "000000";

	/** プールサイズ */
	private static final int MAX_POOL_SIZE = 10;

	/** リトライ回数 */
	private static final int CONN_RETRY_CNT = 5;

	/** コネクションプーリングリスト */
	private static final List<Connection> pool;

	static {
		pool = new ArrayList<Connection>();
		init();
	}

	/**
	 * コンストラクタ
	 */
	private ConnectionManager() {
	}

	/**
	 * 初期化処理
	 */
	private static void init() {
		try {
			// ドライバクラスをロード
			Class.forName("org.mariadb.jdbc.Driver");
			// コネクションプール
			pool();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * コネクションのプーリング処理を行います。
	 * @throws SQLException
	 */
	private static void pool() throws SQLException {
		// DBとの接続処理を行うための接続文字列を作成
		StringBuffer uri = new StringBuffer();
		uri.append("jdbc:mysql://");
		uri.append(DB_SERVER_IP);
		uri.append(":");
		uri.append(PORT_NO);
		uri.append("/");
		uri.append(DB_NAME);
		// jdbc:mysql://127.0.0.1:3306/training
		// コネクションを取得
		System.out.println(uri.toString());
		for (int cnt = 0; cnt < MAX_POOL_SIZE; cnt++) {
			Connection conn = DriverManager.getConnection(uri.toString(), USER_ID, PASSWORD);
			conn.setAutoCommit(true);
			System.out.println("接続しました。");
			pool.add(conn);
		}
	}

	/**
	 * コネクションを解放します。
	 * @throws SQLException
	 */
	public static void closeAll() throws SQLException {
		// コネクションの解放処理
		Iterator<Connection> it = pool.iterator();
		while (it.hasNext()) {
			Connection conn = it.next();
			conn.close();
		}
	}

	/**
	 * コネクションを取得します。
	 * @return conn コネクション
	 * @throws SQLException
	 */
	public static Connection get() throws SQLException {
		int count = 0;
		Connection conn = null;
		while (conn == null) {
			synchronized (pool) {
				if (pool.size() > 0) {
					conn = pool.remove(0);
					break;
				}
			}
			try {
				// コネクションが取得できない場合、スリープしてリトライ
				Thread.sleep(500);
				count++;
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (count > CONN_RETRY_CNT) {
				throw new SQLException("接続が集中しています。");
			}
		}
		return conn;
	}

	/**
	 * コネクションを返却します。
	 * @param conn コネクション
	 */
	public static void release(Connection conn) {
		synchronized (pool) {
			pool.add(conn);
		}
	}

	/**
	 * 使用していないコネクションの数を取得します。
	 * @return size 使用していないコネクションの数
	 */
	public static int getFreeConnectionSize() {
		int size = 0;
		synchronized (pool) {
			size = pool.size();
		}
		return size;
	}

}

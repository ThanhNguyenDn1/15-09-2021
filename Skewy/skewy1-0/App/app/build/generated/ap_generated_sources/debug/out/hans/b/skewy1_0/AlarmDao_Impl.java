package hans.b.skewy1_0;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AlarmDao_Impl implements AlarmDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAlarm;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfAlarm;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfAlarm;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllAlarms;

  public AlarmDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlarm = new EntityInsertionAdapter<Alarm>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `alarm_table`(`id`,`title`,`description`,`dbValue`,`currentTime`,`bitmapByteArray`,`timeStamp`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Alarm value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        stmt.bindLong(4, value.getDbValue());
        if (value.getCurrentTime() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCurrentTime());
        }
        if (value.getBitmapByteArray() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindBlob(6, value.getBitmapByteArray());
        }
        if (value.getTimeStamp() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTimeStamp());
        }
      }
    };
    this.__deletionAdapterOfAlarm = new EntityDeletionOrUpdateAdapter<Alarm>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `alarm_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Alarm value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfAlarm = new EntityDeletionOrUpdateAdapter<Alarm>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `alarm_table` SET `id` = ?,`title` = ?,`description` = ?,`dbValue` = ?,`currentTime` = ?,`bitmapByteArray` = ?,`timeStamp` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Alarm value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        stmt.bindLong(4, value.getDbValue());
        if (value.getCurrentTime() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCurrentTime());
        }
        if (value.getBitmapByteArray() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindBlob(6, value.getBitmapByteArray());
        }
        if (value.getTimeStamp() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTimeStamp());
        }
        stmt.bindLong(8, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllAlarms = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM alarm_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Alarm alarm) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAlarm.insert(alarm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Alarm alarm) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAlarm.handle(alarm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Alarm alarm) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAlarm.handle(alarm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllAlarms() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllAlarms.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllAlarms.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Alarm>> getAllAlarms() {
    final String _sql = "SELECT * FROM alarm_table ORDER BY currentTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"alarm_table"}, false, new Callable<List<Alarm>>() {
      @Override
      public List<Alarm> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDbValue = CursorUtil.getColumnIndexOrThrow(_cursor, "dbValue");
          final int _cursorIndexOfCurrentTime = CursorUtil.getColumnIndexOrThrow(_cursor, "currentTime");
          final int _cursorIndexOfBitmapByteArray = CursorUtil.getColumnIndexOrThrow(_cursor, "bitmapByteArray");
          final int _cursorIndexOfTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timeStamp");
          final List<Alarm> _result = new ArrayList<Alarm>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Alarm _item;
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final int _tmpDbValue;
            _tmpDbValue = _cursor.getInt(_cursorIndexOfDbValue);
            final String _tmpCurrentTime;
            _tmpCurrentTime = _cursor.getString(_cursorIndexOfCurrentTime);
            final byte[] _tmpBitmapByteArray;
            _tmpBitmapByteArray = _cursor.getBlob(_cursorIndexOfBitmapByteArray);
            final String _tmpTimeStamp;
            _tmpTimeStamp = _cursor.getString(_cursorIndexOfTimeStamp);
            _item = new Alarm(_tmpTitle,_tmpDescription,_tmpDbValue,_tmpCurrentTime,_tmpBitmapByteArray,_tmpTimeStamp);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}

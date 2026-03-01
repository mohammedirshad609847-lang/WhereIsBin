package com.example.whereisbin.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ReportDao_Impl implements ReportDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ReportEntity> __insertionAdapterOfReportEntity;

  public ReportDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReportEntity = new EntityInsertionAdapter<ReportEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `reports` (`id`,`category`,`description`,`timestamp`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final ReportEntity entity) {
        statement.bindLong(1, entity.id);
        if (entity.category == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.category);
        }
        if (entity.description == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.description);
        }
        statement.bindLong(4, entity.timestamp);
      }
    };
  }

  @Override
  public void insert(final ReportEntity report) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfReportEntity.insert(report);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ReportEntity> getAll() {
    final String _sql = "SELECT * FROM reports ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
      final List<ReportEntity> _result = new ArrayList<ReportEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final ReportEntity _item;
        _item = new ReportEntity();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfCategory)) {
          _item.category = null;
        } else {
          _item.category = _cursor.getString(_cursorIndexOfCategory);
        }
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _item.description = null;
        } else {
          _item.description = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.timestamp = _cursor.getLong(_cursorIndexOfTimestamp);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

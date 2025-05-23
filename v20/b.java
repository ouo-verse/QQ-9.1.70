package v20;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.tencent.biz.qqcircle.comment.recpic.QFSRecPicInfo;
import java.util.List;

/* compiled from: P */
@Dao
/* loaded from: classes4.dex */
public interface b {
    @Insert(onConflict = 1)
    void a(QFSRecPicInfo qFSRecPicInfo);

    @Query("DELETE FROM rec_pic_info_table WHERE path = :path")
    void delete(String str);

    @Query("DELETE FROM rec_pic_info_table")
    void deleteAll();

    @Query("SELECT * FROM rec_pic_info_table")
    LiveData<List<QFSRecPicInfo>> getAllData();
}

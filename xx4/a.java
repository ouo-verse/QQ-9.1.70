package xx4;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Dao
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H'J\b\u0010\n\u001a\u00020\u0004H'\u00a8\u0006\u000b"}, d2 = {"Lxx4/a;", "", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "resource", "", "b", "a", "", "key", "get", QCircleLpReportDc05507.KEY_CLEAR, "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface a {
    @Delete
    void a(@NotNull ZPlanRecordResource resource);

    @Insert(onConflict = 1)
    void b(@NotNull ZPlanRecordResource resource);

    @Query("DELETE FROM RecordResource")
    void clear();

    @Query("SELECT * FROM RecordResource WHERE resourceKey LIKE :key LIMIT 1")
    @Nullable
    ZPlanRecordResource get(@NotNull String key);
}

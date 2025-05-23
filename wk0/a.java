package wk0;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.filament.zplan.business.api.IBusinessScene;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import vk0.c;

/* compiled from: P */
@Deprecated(message = "\u5df2\u5e9f\u5f03, \u4f7f\u7528[com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305]\u591a\u4eba\u7248\u672c\u8fdb\u884c\u63a5\u5165")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lwk0/a;", "Lwk0/b;", "Lvk0/b;", "Lvk0/c;", "", "entry", "Lcom/tencent/filament/zplan/business/api/IBusinessScene;", "businessScene", "", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface a extends b, vk0.b, c {
    int A();

    int y(@NotNull String entry, @NotNull IBusinessScene businessScene);
}

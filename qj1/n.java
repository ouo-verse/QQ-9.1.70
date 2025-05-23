package qj1;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Triple;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\u001a\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001a\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u000e\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lqj1/n;", "", "", "L", "u", "t", "r", UserInfo.SEX_FEMALE, "Lkotlin/Triple;", "", "getRoleInfo", "", "getPersonalMedal", "J", ReportConstant.COSTREPORT_PREFIX, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface n {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static int a(@NotNull n nVar) {
            return 0;
        }

        @NotNull
        public static Triple<Long, Long, String> b(@NotNull n nVar) {
            return new Triple<>(0L, 0L, "");
        }

        @NotNull
        public static String c(@NotNull n nVar) {
            return "";
        }

        @NotNull
        public static Triple<Integer, Integer, String> d(@NotNull n nVar) {
            return new Triple<>(0, 0, "");
        }
    }

    @NotNull
    String F();

    @Nullable
    String J();

    @Nullable
    String L();

    @NotNull
    Triple<Long, Long, String> getPersonalMedal();

    @NotNull
    Triple<Integer, Integer, String> getRoleInfo();

    @NotNull
    String r();

    int s();

    @NotNull
    String t();

    @Nullable
    String u();
}

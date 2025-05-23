package pw0;

import com.tencent.mobileqq.icgame.api.login.ILiveLoginApi;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lpw0/b;", "", "", "uid", "", "c", "roomId", "", "isOpenAnchorProfile", "acquireAnchorUid", "b", "a", "isShowGiftBtn", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class a {
        public static long a(@NotNull b bVar) {
            LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo("1078", ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
            if (loginInfo != null) {
                return loginInfo.getUid();
            }
            return 0L;
        }

        public static boolean b(@NotNull b bVar, long j3) {
            if (bVar.acquireAnchorUid(j3) == bVar.a()) {
                return true;
            }
            return false;
        }

        public static boolean c(@NotNull b bVar) {
            return false;
        }
    }

    long a();

    long acquireAnchorUid(long roomId);

    boolean b(long roomId);

    void c(long uid);

    boolean isOpenAnchorProfile(long roomId, long uid);

    boolean isShowGiftBtn();
}

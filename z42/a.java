package z42;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewParent;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUser;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUserMsg;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w42.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0001H&J\u0016\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H&J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u0016\u0010\u0015\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H&J,\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u001aH&J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\u0016H&J\n\u0010 \u001a\u0004\u0018\u00010\u001fH&JP\u0010,\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00162\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020&0%2\u0006\u0010)\u001a\u00020(2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020*0%H&JD\u00101\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u00132\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00162\u0006\u00100\u001a\u00020\u00162\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u001aH&J\u0012\u00104\u001a\u00020\u00132\b\u00103\u001a\u0004\u0018\u000102H\u0016\u00a8\u00065"}, d2 = {"Lz42/a;", "", "", "register", "unregister", "", "roomId", "", "d", "msg", ReportConstant.COSTREPORT_PREFIX, "datas", DomainData.DOMAIN_NAME, "Lw42/f;", "", "index", HippyTKDListViewAdapter.X, "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$AtUserMsg;", "atUserMsg", "", "b", "B", "", "click", "Ljava/lang/Object;", "arg", "", "businessParams", "reportEvent", "message", "decodeQQEmotion", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "getSelfUserInfo", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatTextMsgItemView;", "view", "start", "text", "", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "atUserInfoMap", "Landroid/text/SpannableStringBuilder;", "spannable", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$AtUser;", "uidAtInfoMap", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "a", "Landroid/view/ViewParent;", "parentView", "u", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: z42.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C11651a {
        public static /* synthetic */ void a(a aVar, View view, boolean z16, String str, String str2, Map map, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                boolean z17 = z16;
                if ((i3 & 4) != 0) {
                    str = null;
                }
                String str3 = str;
                if ((i3 & 16) != 0) {
                    map = new HashMap();
                }
                aVar.a(view, z17, str3, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindElementInfo");
        }

        public static boolean b(@NotNull a aVar, @Nullable ViewParent viewParent) {
            return false;
        }
    }

    void B(@NotNull List<Object> datas);

    void C(@NotNull ChatTextMsgItemView view, int start, @NotNull String text, @NotNull Map<String, CommonOuterClass$QQUserId> atUserInfoMap, @NotNull SpannableStringBuilder spannable, @NotNull Map<Long, MessageOuterClass$AtUser> uidAtInfoMap);

    void a(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams);

    boolean b(@Nullable MessageOuterClass$AtUserMsg atUserMsg);

    @Nullable
    List<Object> d(long roomId);

    @Nullable
    String decodeQQEmotion(@NotNull String message);

    @Nullable
    LiveUserInfo getSelfUserInfo();

    void n(@NotNull List<Object> datas);

    void register();

    void reportEvent(@NotNull String click, @NotNull Object arg, @NotNull Map<String, String> businessParams);

    void s(@NotNull Object msg2);

    boolean u(@Nullable ViewParent parentView);

    void unregister();

    void x(@NotNull f msg2, int index);
}

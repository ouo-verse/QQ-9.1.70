package vi2;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewParent;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$AtUser;
import trpc.yes.common.MessageOuterClass$AtUserMsg;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0001H&J\u0016\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H&J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0011\u001a\u00020\u000fH&J,\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0016H&J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u0012H&J\b\u0010\u001b\u001a\u00020\u0005H&JP\u0010(\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00122\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\"0!2\u0006\u0010%\u001a\u00020$2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020&0!H&JD\u0010-\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u000f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00122\u0006\u0010,\u001a\u00020\u00122\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0016H&J\u0012\u00100\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00101\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u00102\u001a\u00020\u000fH&\u00a8\u00063"}, d2 = {"Lvi2/a;", "", "", "register", "unregister", "", "roomId", "", "d", "newMsg", ReportConstant.COSTREPORT_PREFIX, "datas", DomainData.DOMAIN_NAME, "Ltrpc/yes/common/MessageOuterClass$AtUserMsg;", "atUserMsg", "", "N", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "click", "Ljava/lang/Object;", "arg", "", "businessParams", "reportEvent", "message", "decodeQQEmotion", "c", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTextMsgItemView;", "view", "", "start", "text", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "atUserInfoMap", "Landroid/text/SpannableStringBuilder;", "spannable", "Ltrpc/yes/common/MessageOuterClass$AtUser;", "uidAtInfoMap", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "a", "Landroid/view/ViewParent;", "parentView", "u", BdhLogUtil.LogTag.Tag_Req, "b", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: vi2.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C11420a {
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

    void C(@NotNull ChatTextMsgItemView view, int start, @NotNull String text, @NotNull Map<String, CommonOuterClass$QQUserId> atUserInfoMap, @NotNull SpannableStringBuilder spannable, @NotNull Map<Long, MessageOuterClass$AtUser> uidAtInfoMap);

    boolean N(@Nullable MessageOuterClass$AtUserMsg atUserMsg);

    int R(long roomId);

    void a(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams);

    boolean b();

    long c();

    @Nullable
    List<Object> d(long roomId);

    @Nullable
    String decodeQQEmotion(@NotNull String message);

    void n(@NotNull List<Object> datas);

    void register();

    void reportEvent(@NotNull String click, @NotNull Object arg, @NotNull Map<String, String> businessParams);

    void s(@NotNull Object newMsg);

    boolean u(@Nullable ViewParent parentView);

    void unregister();

    boolean z();
}

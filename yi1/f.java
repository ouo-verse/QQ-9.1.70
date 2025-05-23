package yi1;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchManageOperateReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchManageOperateRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSelectParam;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchManageOperateCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xi1.BatchManageOperate;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R$\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lyi1/f;", "", "", "targetChannelId", "Lxi1/a;", "state", "originalChannelId", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchManageOperateReq;", "c", "channelId", "", "d", "Lyi1/g;", "listener", "g", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "b", "getKeyWord", "keyWord", "Lyi1/g;", "getMOperationListener", "()Lyi1/g;", "setMOperationListener", "(Lyi1/g;)V", "mOperationListener", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String keyWord;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g mOperationListener;

    public f(@NotNull String guildId, @NotNull String keyWord) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        this.guildId = guildId;
        this.keyWord = keyWord;
    }

    private final GProBatchManageOperateReq c(String targetChannelId, BatchManageOperate state, String originalChannelId) {
        GProBatchManageOperateReq gProBatchManageOperateReq = new GProBatchManageOperateReq();
        gProBatchManageOperateReq.guildId = MiscKt.l(this.guildId);
        long l3 = MiscKt.l(originalChannelId);
        gProBatchManageOperateReq.orgChannelId = l3;
        QLog.d("BatchDeleteFeedOperator", 1, "constructBatchMoveFeedRequest " + l3);
        gProBatchManageOperateReq.operateType = 1;
        gProBatchManageOperateReq.channelId = MiscKt.l(targetChannelId);
        if (state.getSelectMode() == 1) {
            GProSelectParam gProSelectParam = new GProSelectParam();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(state.e());
            gProSelectParam.feedIds = arrayList;
            gProBatchManageOperateReq.exclude = gProSelectParam;
            GProSelectParam gProSelectParam2 = new GProSelectParam();
            gProSelectParam2.selectChannel = TextUtils.isEmpty(this.keyWord);
            gProSelectParam2.searchWord = this.keyWord;
            gProBatchManageOperateReq.include = gProSelectParam2;
        } else {
            GProSelectParam gProSelectParam3 = new GProSelectParam();
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.addAll(state.d());
            gProSelectParam3.feedIds = arrayList2;
            gProBatchManageOperateReq.include = gProSelectParam3;
        }
        return gProBatchManageOperateReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final f this$0, final int i3, final String str, GProBatchManageOperateRsp gProBatchManageOperateRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("BatchMoveFeedOperator", 1, "BatchMoveFeedOperator|result=" + i3 + ", errMsg=" + str + ", toast=" + gProBatchManageOperateRsp.toast);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: yi1.e
            @Override // java.lang.Runnable
            public final void run() {
                f.f(i3, str, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, String errMsg, f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (n.v(i3)) {
            n.B(false, R.string.f144630pa);
            return;
        }
        if (i3 != 0) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            n.A(0, errMsg);
            return;
        }
        n.A(2, "\u79fb\u5e16\u6210\u529f");
        g gVar = this$0.mOperationListener;
        if (gVar != null) {
            gVar.a(true);
        }
    }

    public final void d(@NotNull String targetChannelId, @NotNull BatchManageOperate state, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(targetChannelId, "targetChannelId");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        GProBatchManageOperateReq c16 = c(targetChannelId, state, channelId);
        o c17 = l.c();
        if (c17 != null) {
            c17.batchManageOperate(c16, new IGProBatchManageOperateCallback() { // from class: yi1.d
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchManageOperateCallback
                public final void onResult(int i3, String str, GProBatchManageOperateRsp gProBatchManageOperateRsp) {
                    f.e(f.this, i3, str, gProBatchManageOperateRsp);
                }
            });
        }
    }

    public final void g(@NotNull g listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOperationListener = listener;
    }
}

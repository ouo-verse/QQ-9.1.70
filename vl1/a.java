package vl1;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStLike;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import hl1.g;
import jl1.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&J@\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0010H&J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0006H&J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0010H&J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0010H&J(\u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010(\u001a\u00020'H&J\b\u0010*\u001a\u00020\fH&J\n\u0010+\u001a\u0004\u0018\u00010\fH&J\n\u0010,\u001a\u0004\u0018\u00010\fH&J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\fH&J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\fH&J\b\u00100\u001a\u00020\u0010H&J\u0012\u00102\u001a\u0004\u0018\u00010\f2\u0006\u00101\u001a\u00020\u0010H&\u00a8\u00063"}, d2 = {"Lvl1/a;", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "commentMeta", "", "H1", "Ljl1/h;", "reply", "payload", "O4", "Landroid/view/View;", "view", "", "tinyId", "", "uin", "", "type", WSAutoShowCommentParams.KEY_COMMENT_ID, WSAutoShowCommentParams.KEY_REPLY_ID, "groupPos", "U8", "position", "Lhl1/g;", "contentData", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStLike;", "oldLikeInfo", Constants.DEVICE_BOOT_TIME, "", "needFold", "replyItemData", ICustomDataEditor.STRING_ARRAY_PARAM_3, "Ljl1/b;", "commentItemData", ICustomDataEditor.NUMBER_PARAM_4, "A6", "q6", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "gproStImage", "Landroid/content/Context;", "context", "N6", "r", "getGuildId", "getChannelId", "id", "G0", "v3", "z3", "itemGroupPosition", "S3", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a {
    void A6(@NotNull g contentData, int position);

    void G0(@NotNull String id5);

    void G7(int position, @NotNull g contentData, @NotNull GProStLike oldLikeInfo);

    void H1(@NotNull ReplyCommentArgs commentMeta);

    void N6(@NotNull GProStImage gproStImage, @NotNull String commentId, @NotNull String replyId, @NotNull Context context);

    void O4(@NotNull h reply, @Nullable Object payload);

    @Nullable
    String S3(int itemGroupPosition);

    void U8(@NotNull View view, @NotNull String tinyId, long uin, int type, @NotNull String commentId, @NotNull String replyId, int groupPos);

    void a3(boolean needFold, @NotNull h replyItemData);

    @Nullable
    String getChannelId();

    @Nullable
    String getGuildId();

    void n4(@NotNull jl1.b commentItemData);

    void q6(@NotNull g contentData, int position);

    @NotNull
    String r();

    void v3(@NotNull String id5);

    int z3();
}

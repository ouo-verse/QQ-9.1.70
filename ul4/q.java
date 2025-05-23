package ul4;

import ag4.i;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.av.utils.ba;
import com.tencent.avbiz.Constants;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.newnearby.INearbyAddFriendHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.timi.game.profile.impl.view.ProfileItemInTeamView;
import com.tencent.timi.game.profile.impl.view.ProfileUserInfoView;
import com.tencent.timi.game.profile.impl.view.forbidden.UpdateForbiddenEvent;
import com.tencent.timi.game.profile.impl.view.record.ProfileRecordArkView;
import com.tencent.timi.game.profile.impl.view.record.ProfileSmobaRecordView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.GameDataServerOuterClass$UserDefaultRole;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomForbiddenSpeechInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomJudgeForbiddenSpeechRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0007\n\u0002\b\u0006*\u0004\u00d3\u0001\u00da\u0001\b&\u0018\u00002\u00020\u00012\u00020\u0002Bb\u0012\u0006\u0010]\u001a\u00020X\u0012\u0006\u0010c\u001a\u00020^\u0012\u0006\u0010f\u001a\u00020\t\u0012\u0006\u0010l\u001a\u00020\t\u0012\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001b\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010x\u001a\u00020\t\u0012\u0006\u0010}\u001a\u00020\u0005\u0012\t\b\u0002\u0010\u0082\u0001\u001a\u00020\"\u00a2\u0006\u0006\b\u00dd\u0001\u0010\u00de\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0002J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001bH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0002J\u0012\u0010)\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010'H\u0014J\b\u0010*\u001a\u00020\u0003H\u0014J\b\u0010+\u001a\u00020\u0003H\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J\u0006\u0010-\u001a\u00020\u0005J\b\u0010.\u001a\u00020\u0003H&J\u000e\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020/J\u0010\u00102\u001a\u00020\u00032\u0006\u00100\u001a\u00020/H\u0004J\u0010\u00105\u001a\u00020\u00032\u0006\u00104\u001a\u000203H\u0004J\u0010\u00107\u001a\u00020\"2\u0006\u00106\u001a\u00020\tH\u0004J\u001a\u00109\u001a\u00020\u00032\u0006\u00106\u001a\u00020\t2\b\u00108\u001a\u0004\u0018\u00010/H\u0004J\b\u0010:\u001a\u00020\u0003H\u0004J\b\u0010;\u001a\u00020\"H\u0016J\b\u0010<\u001a\u00020\tH\u0016J \u0010A\u001a\u00020@2\u0006\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\"H\u0004J#\u0010D\u001a\u00020\u00032\u0012\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0B\"\u00020/H\u0004\u00a2\u0006\u0004\bD\u0010EJ\b\u0010F\u001a\u00020\u0005H\u0016J\n\u0010G\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010I\u001a\u00020\u00032\u0006\u0010H\u001a\u00020/H\u0016J\b\u0010J\u001a\u00020\u0003H\u0004J\b\u0010K\u001a\u0004\u0018\u00010/J\b\u0010L\u001a\u0004\u0018\u00010/J\b\u0010M\u001a\u0004\u0018\u00010/J\n\u0010N\u001a\u0004\u0018\u00010/H\u0004J\b\u0010O\u001a\u00020\tH\u0004J\u0010\u0010Q\u001a\u00020\u00032\u0006\u0010P\u001a\u00020@H\u0004J\b\u0010R\u001a\u00020\u0003H\u0004J\u0012\u0010T\u001a\u00020\u00032\b\u0010S\u001a\u0004\u0018\u00010@H\u0004J\b\u0010U\u001a\u00020\u0003H\u0004J\u0010\u0010W\u001a\u00020\u00032\u0006\u0010V\u001a\u00020\tH\u0016R\u001a\u0010]\u001a\u00020X8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001a\u0010c\u001a\u00020^8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u0014\u0010f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\"\u0010l\u001a\u00020\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010e\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR.\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001c\u0010%\u001a\u0004\u0018\u00010$8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR\u0014\u0010x\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010eR\u001a\u0010}\u001a\u00020\u00058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R\u001d\u0010\u0082\u0001\u001a\u00020\"8\u0004X\u0084\u0004\u00a2\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0016\u0010\u0084\u0001\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010zR\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001b\u0010\u008f\u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001a\u0010\u009c\u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bG\u0010\u008e\u0001R\u001b\u0010\u009e\u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u008e\u0001R\u001c\u0010\u00a0\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u0087\u0001R\u001c\u0010\u00a4\u0001\u001a\u0005\u0018\u00010\u00a1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u001b\u0010\u00a7\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u001b\u0010\u00a9\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a6\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u00aa\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u001b\u0010\u00af\u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u008e\u0001R\u001c\u0010\u00b3\u0001\u001a\u0005\u0018\u00010\u00b0\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u00b2\u0001R\u0016\u0010\u00b5\u0001\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u00b4\u0001\u0010zR+\u0010\u00bb\u0001\u001a\u0004\u0018\u00010/8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00b6\u0001\u0010\u008e\u0001\u001a\u0006\b\u00b7\u0001\u0010\u00b8\u0001\"\u0006\b\u00b9\u0001\u0010\u00ba\u0001R\u0017\u0010\u00be\u0001\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u00bd\u0001R&\u0010\u00c2\u0001\u001a\u00020\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0015\n\u0005\b\u00bf\u0001\u0010e\u001a\u0005\b\u00c0\u0001\u0010i\"\u0005\b\u00c1\u0001\u0010kR\u0018\u0010\u00c4\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00c3\u0001\u0010eR\u001a\u0010\u00c5\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bF\u0010\u00a6\u0001R%\u0010\u00c6\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b7\u0010e\u001a\u0005\b\u00c6\u0001\u0010i\"\u0005\b\u00c7\u0001\u0010kR+\u0010\u00ce\u0001\u001a\u0005\u0018\u00010\u00c8\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\bK\u0010\u00c9\u0001\u001a\u0006\b\u00ca\u0001\u0010\u00cb\u0001\"\u0006\b\u00cc\u0001\u0010\u00cd\u0001R\u001a\u0010\u00d0\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b;\u0010\u00cf\u0001R\u001a\u0010\u00d1\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0010\u0010\u00cf\u0001R\u001a\u0010\u00d2\u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001c\u0010\u008e\u0001R\u0017\u0010\u00d5\u0001\u001a\u00030\u00d3\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bL\u0010\u00d4\u0001R'\u0010\u00d9\u0001\u001a\u00020\"8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0016\n\u0004\bM\u0010\u007f\u001a\u0006\b\u00d6\u0001\u0010\u0081\u0001\"\u0006\b\u00d7\u0001\u0010\u00d8\u0001R\u0017\u0010\u00dc\u0001\u001a\u00030\u00da\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b-\u0010\u00db\u0001\u00a8\u0006\u00df\u0001"}, d2 = {"Lul4/q;", "Lsl4/a;", "Landroid/view/View$OnClickListener;", "", "Z0", "", "value", "k1", "A1", "", "open", "t1", "initView", "u1", "c1", "C1", "B0", "roleName", "o1", "B1", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "selectedDefaultAccount", "F1", "Y0", "p1", "E1", "l1", "", "C0", "d1", "h1", "Lgh4/d;", "it", "X0", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "", "roomId", "m1", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onStart", "show", "dismiss", "F0", "init", "Landroid/view/View;", "view", "J0", "v1", "Lcom/tencent/mobileqq/newnearby/INearbyAddFriendHelper$c;", "listener", "f1", IProfileProtocolConst.PARAM_IS_FRIEND, "y0", "addFriendButton", "z1", "r1", "A0", "L0", "textResId", "textColor", "backgroundColor", "Landroid/widget/TextView;", "Q0", "", "views", "K0", "([Landroid/view/View;)V", "x0", "j0", "v", NodeProps.ON_CLICK, "j1", "z0", "D0", "E0", "H0", "i1", "micInvitingTextView", "O0", "M0", "microTextView", "P0", "N0", "needShow", "x1", "Lcom/tencent/mobileqq/app/QBaseActivity;", "T", "Lcom/tencent/mobileqq/app/QBaseActivity;", "R0", "()Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "U", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "V0", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "V", "Z", "isHeightWrap", "W", "e1", "()Z", "setCaptain", "(Z)V", "isCaptain", "X", "Ljava/util/Map;", "T0", "()Ljava/util/Map;", "setReportParamMap", "(Ljava/util/Map;)V", "reportParamMap", "Y", "Ljava/lang/Long;", "U0", "()Ljava/lang/Long;", "showFleetState", "a0", "Ljava/lang/String;", "getPageReportName", "()Ljava/lang/String;", "pageReportName", "b0", "I", "S0", "()I", "gameIdFromOuter", "c0", "TAG", "Landroid/view/ViewGroup;", "d0", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/timi/game/profile/impl/view/ProfileUserInfoView;", "e0", "Lcom/tencent/timi/game/profile/impl/view/ProfileUserInfoView;", "userInfoView", "f0", "Landroid/view/View;", "roleInfoFrame", "Lcom/tencent/timi/game/profile/impl/view/record/ProfileSmobaRecordView;", "g0", "Lcom/tencent/timi/game/profile/impl/view/record/ProfileSmobaRecordView;", "smobaRecordView", "Lcom/tencent/timi/game/profile/impl/view/record/ProfileRecordArkView;", "h0", "Lcom/tencent/timi/game/profile/impl/view/record/ProfileRecordArkView;", "gameRecordArkView", "Landroid/widget/FrameLayout;", "i0", "Landroid/widget/FrameLayout;", "gameRecordArkFrame", "gameRecordFrame", "k0", "reportButton", "l0", "operationFrame", "Landroid/widget/LinearLayout;", "m0", "Landroid/widget/LinearLayout;", "bottomLinear", "n0", "Landroid/widget/TextView;", "roleNameText", "o0", "roleNameTitle", "Lcom/tencent/mobileqq/widget/RoundImageView;", "p0", "Lcom/tencent/mobileqq/widget/RoundImageView;", "profileAvatarBgView", "q0", "closeButton", "Lcom/tencent/timi/game/profile/impl/view/ProfileItemInTeamView;", "r0", "Lcom/tencent/timi/game/profile/impl/view/ProfileItemInTeamView;", "profileItemInTeamView", "s0", "defaultAvatarUrl", "t0", "getProfileRelView", "()Landroid/view/View;", "setProfileRelView", "(Landroid/view/View;)V", "profileRelView", "u0", "J", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "v0", "g1", "setMaster", "isMaster", "w0", "isDismissed", "settingForbiddenButton", "isFromMicPos", "w1", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "W0", "()Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "y1", "(Lcom/tencent/timi/game/userinfo/api/IUserInfo;)V", ITVKPlayerEventListener.KEY_USER_INFO, "Ljava/lang/Boolean;", "isUserQQFriend", "isAddQQFriendOpen", "addQQFriendView", "ul4/q$c", "Lul4/q$c;", "eventReceiver", "getMYesGameId", "setMYesGameId", "(I)V", "mYesGameId", "ul4/q$j", "Lul4/q$j;", "speakingListener", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ltrpc/yes/common/CommonOuterClass$QQUserId;ZZLjava/util/Map;Ljava/lang/Long;ZLjava/lang/String;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class q extends sl4.a implements View.OnClickListener {

    /* renamed from: A0, reason: from kotlin metadata */
    @Nullable
    private Boolean isUserQQFriend;

    /* renamed from: B0, reason: from kotlin metadata */
    @Nullable
    private Boolean isAddQQFriendOpen;

    /* renamed from: C0, reason: from kotlin metadata */
    @Nullable
    private View addQQFriendView;

    /* renamed from: D0, reason: from kotlin metadata */
    @NotNull
    private final c eventReceiver;

    /* renamed from: E0, reason: from kotlin metadata */
    private int mYesGameId;

    /* renamed from: F0, reason: from kotlin metadata */
    @NotNull
    private final j speakingListener;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final QBaseActivity activity;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final CommonOuterClass$QQUserId userId;

    /* renamed from: V, reason: from kotlin metadata */
    private final boolean isHeightWrap;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isCaptain;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private Map<String, String> reportParamMap;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private final Long roomId;

    /* renamed from: Z, reason: from kotlin metadata */
    private final boolean showFleetState;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pageReportName;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final int gameIdFromOuter;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup rootView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ProfileUserInfoView userInfoView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View roleInfoFrame;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ProfileSmobaRecordView smobaRecordView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ProfileRecordArkView gameRecordArkView;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout gameRecordArkFrame;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View gameRecordFrame;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View reportButton;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup operationFrame;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout bottomLinear;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView roleNameText;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView roleNameTitle;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundImageView profileAvatarBgView;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View closeButton;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ProfileItemInTeamView profileItemInTeamView;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String defaultAvatarUrl;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View profileRelView;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private final long currentTime;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private boolean isMaster;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private boolean isDismissed;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView settingForbiddenButton;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private boolean isFromMicPos;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IUserInfo userInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ul4/q$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
        a() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp result) {
            com.tencent.timi.game.utils.l.b(q.this.TAG, ">>cpddMicInviting success");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.utils.l.b(q.this.TAG, ">>cpddMicInviting error errCode=" + errorCode + " errMsg=" + errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ul4/q$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
        b() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp result) {
            com.tencent.timi.game.ui.widget.f.c("\u79fb\u51fa\u9ea6\u4f4d\u6210\u529f");
            com.tencent.timi.game.utils.l.b(q.this.TAG, "OutUserSpeaking  - success");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.ui.widget.f.c("\u79fb\u51fa\u9ea6\u4f4d\u5931\u8d25");
            com.tencent.timi.game.utils.l.e(q.this.TAG, "OutUserSpeaking  - onError " + errorCode + "," + errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007H\u0016\u00a8\u0006\n"}, d2 = {"ul4/q$c", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/timi/game/profile/impl/view/forbidden/UpdateForbiddenEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "simpleBaseEvent", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements SimpleEventReceiver<UpdateForbiddenEvent> {
        c() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<UpdateForbiddenEvent>> getEventClass() {
            ArrayList<Class<UpdateForbiddenEvent>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(UpdateForbiddenEvent.class);
            return arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
            if (simpleBaseEvent instanceof UpdateForbiddenEvent) {
                com.tencent.timi.game.utils.l.i(q.this.TAG, "onReceiveEvent : UpdateNoticeEvent");
                Long roomId = q.this.getRoomId();
                if (roomId != null) {
                    q.this.m1(((UpdateForbiddenEvent) simpleBaseEvent).second, roomId.longValue());
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ul4/q$d", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            q.this.dismiss();
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ul4/q$f", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements IResultListener<IUserInfo> {
        f() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo result) {
            long j3;
            long j16;
            String str;
            bo4.e d16;
            bo4.e d17;
            bo4.e d18;
            if (result != null && (d18 = result.d()) != null) {
                j3 = d18.b();
            } else {
                j3 = 0;
            }
            IUserInfo userInfo = q.this.getUserInfo();
            if (userInfo != null && (d17 = userInfo.d()) != null) {
                j16 = d17.b();
            } else {
                j16 = 0;
            }
            IUserInfo userInfo2 = q.this.getUserInfo();
            if (userInfo2 != null && (d16 = userInfo2.d()) != null) {
                str = d16.a();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            String str2 = str;
            if (j3 != 0 && j16 != 0) {
                ((bm4.a) mm4.b.b(bm4.a.class)).B0(j3, j16, str2, q.this.A0());
                return;
            }
            com.tencent.timi.game.utils.l.e("CPDDProfileDialog", "getUserInfoFromDBOrNet invalid " + j3 + " " + j16);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.utils.l.e("CPDDProfileDialog", "getUserInfoFromDBOrNet error " + errorCode + " " + errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"ul4/q$h", "Lpl4/d;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomJudgeForbiddenSpeechRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class h implements pl4.d<YoloRoomOuterClass$YoloRoomJudgeForbiddenSpeechRsp> {
        h() {
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable YoloRoomOuterClass$YoloRoomJudgeForbiddenSpeechRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            com.tencent.timi.game.utils.l.e(q.this.TAG, "JudgeForbiddenSpeech failed : errorCode == " + timiErrCode + ",errorMessage == " + timiErrMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable YoloRoomOuterClass$YoloRoomJudgeForbiddenSpeechRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            YoloRoomOuterClass$YoloRoomForbiddenSpeechInfo yoloRoomOuterClass$YoloRoomForbiddenSpeechInfo;
            PBInt32Field pBInt32Field;
            if (response != null && (yoloRoomOuterClass$YoloRoomForbiddenSpeechInfo = response.info) != null && (pBInt32Field = yoloRoomOuterClass$YoloRoomForbiddenSpeechInfo.second) != null) {
                int i3 = pBInt32Field.get();
                q qVar = q.this;
                qVar.m1(i3, qVar.getRoomId().longValue());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ul4/q$j", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class j implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
        j() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp result) {
            com.tencent.timi.game.ui.widget.f.c("\u4e0b\u9ea6\u6210\u529f");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.ui.widget.f.c("\u4e0b\u9ea6\u5931\u8d25");
        }
    }

    public /* synthetic */ q(QBaseActivity qBaseActivity, CommonOuterClass$QQUserId commonOuterClass$QQUserId, boolean z16, boolean z17, Map map, Long l3, boolean z18, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(qBaseActivity, commonOuterClass$QQUserId, z16, z17, map, l3, z18, str, (i16 & 256) != 0 ? 0 : i3);
    }

    private final void A1() {
        if (Intrinsics.areEqual(this.isUserQQFriend, Boolean.FALSE) && Intrinsics.areEqual(this.isAddQQFriendOpen, Boolean.TRUE)) {
            View view = this.addQQFriendView;
            if (view != null) {
                fh4.g.o(view, true);
                return;
            }
            return;
        }
        View view2 = this.addQQFriendView;
        if (view2 != null) {
            fh4.g.o(view2, false);
        }
    }

    private final String B0() {
        String str;
        PBStringField pBStringField;
        YesGameInfoOuterClass$GameConfigInfo l16 = ((ag4.h) mm4.b.b(ag4.h.class)).l1(A0());
        if (l16 != null && (pBStringField = l16.game_name) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void B1() {
        YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
        LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> B2 = ((ag4.i) mm4.b.b(ag4.i.class)).B2(this.mYesGameId);
        if (B2 != null) {
            yesGameInfoOuterClass$GetUserGameDefaultRoleRsp = B2.getValue();
        } else {
            yesGameInfoOuterClass$GetUserGameDefaultRoleRsp = null;
        }
        com.tencent.timi.game.utils.l.b(this.TAG, "showSmobaAccountSelectDialog  - defaultAccount=" + yesGameInfoOuterClass$GetUserGameDefaultRoleRsp);
        if (yesGameInfoOuterClass$GetUserGameDefaultRoleRsp != null) {
            l1();
        } else {
            ((ag4.i) mm4.b.b(ag4.i.class)).F3(this.mYesGameId, this.activity, Boolean.TRUE, null, new i());
        }
    }

    private final Map<String, String> C0() {
        long j3;
        HashMap hashMap = new HashMap(this.reportParamMap);
        hashMap.put("yes_leave_reason", "0");
        Long l3 = this.roomId;
        if (l3 != null) {
            l3.longValue();
            gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId.longValue());
            if (K0 != null) {
                j3 = K0.A(this.userId);
            } else {
                j3 = 0;
            }
            hashMap.put("yes_stay_duration", String.valueOf(j3));
        }
        return hashMap;
    }

    private final void C1() {
        List<CommonOuterClass$QQUserId> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(this.userId);
        ((bo4.d) mm4.b.b(bo4.d.class)).W(A0(), listOf, 2, new l());
        ((bo4.d) mm4.b.b(bo4.d.class)).G3(this.userId, A0(), new k());
    }

    private final void E1(YesGameInfoOuterClass$GetUserGameDefaultRoleRsp selectedDefaultAccount) {
        com.tencent.timi.game.utils.l.i(this.TAG, "updateRoleInfo ");
        o1(selectedDefaultAccount.role_info.role_name.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1(YesGameInfoOuterClass$GetUserGameDefaultRoleRsp selectedDefaultAccount) {
        List<CommonOuterClass$QQUserId> listOf;
        E1(selectedDefaultAccount);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(this.userId);
        ((bo4.d) mm4.b.b(bo4.d.class)).W(A0(), listOf, 2, null);
        ((bo4.d) mm4.b.b(bo4.d.class)).c1(this.userId, null);
        if (A0() != 101) {
            ProfileRecordArkView profileRecordArkView = this.gameRecordArkView;
            boolean z16 = false;
            if (profileRecordArkView != null && profileRecordArkView.getVisibility() == 0) {
                z16 = true;
            }
            if (z16) {
                p1();
                Y0();
                ProfileRecordArkView profileRecordArkView2 = this.gameRecordArkView;
                if (profileRecordArkView2 != null) {
                    profileRecordArkView2.j(A0(), this.userId, this.reportParamMap, this.pageReportName, this.isMaster);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(q this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.a()) {
            if (this$0.roomId != null) {
                ((fm4.g) mm4.b.b(fm4.g.class)).A(this$0.roomId.longValue()).i(this$0.speakingListener);
            }
            ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_leave_mic", this$0.C0());
            this$0.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void X0(gh4.d it) {
        HashMap<String, String> E = it.E();
        E.put("yes_game_id", String.valueOf(A0()));
        E.put("yes_to_uid", String.valueOf(this.userId.uid.get()));
        E.put("yes_to_yes_uid", nn4.a.a(this.userId.yes_uid.get()));
        TextView textView = this.settingForbiddenButton;
        if (textView != null) {
            ((ug4.b) mm4.b.b(ug4.b.class)).a(textView, true, null, "em_yes_userprofile_panel_mute", E);
        }
    }

    private final void Y0() {
        if (this.gameRecordArkView == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            this.gameRecordArkView = new ProfileRecordArkView(context);
            FrameLayout frameLayout = this.gameRecordArkFrame;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            FrameLayout frameLayout2 = this.gameRecordArkFrame;
            if (frameLayout2 != null) {
                frameLayout2.addView(this.gameRecordArkView);
            }
        }
    }

    private final void Z0() {
        SimpleEventBus.getInstance().registerReceiver(this.eventReceiver);
        k1("init start ======");
        if (this.isHeightWrap) {
            setContentView(R.layout.hvs);
        } else {
            setContentView(R.layout.hvq);
        }
        ((hn4.a) mm4.b.b(hn4.a.class)).H1(findViewById(android.R.id.content));
        this.isMaster = ll4.b.a(((ll4.a) mm4.b.b(ll4.a.class)).E(), this.userId);
        this.mYesGameId = A0();
        initView();
        c1();
        k1("outer init start ");
        init();
        k1("outer init end ");
        ProfileItemInTeamView profileItemInTeamView = this.profileItemInTeamView;
        if (profileItemInTeamView != null) {
            profileItemInTeamView.setClickListener(new d());
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ul4.o
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                q.b1(q.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(q this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().unRegisterReceiver(this$0.eventReceiver);
    }

    private final void c1() {
        YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
        ProfileItemInTeamView profileItemInTeamView;
        C1();
        ((bo4.d) mm4.b.b(bo4.d.class)).N0(this.userId, new e());
        View view = this.reportButton;
        if (view != null) {
            fh4.g.o(view, !this.isMaster);
        }
        if (A0() == 101) {
            ProfileSmobaRecordView profileSmobaRecordView = this.smobaRecordView;
            if (profileSmobaRecordView != null) {
                profileSmobaRecordView.setUserId(this.userId);
            }
        } else {
            Y0();
            ProfileRecordArkView profileRecordArkView = this.gameRecordArkView;
            if (profileRecordArkView != null) {
                profileRecordArkView.j(A0(), this.userId, this.reportParamMap, this.pageReportName, this.isMaster);
            }
        }
        ProfileUserInfoView profileUserInfoView = this.userInfoView;
        if (profileUserInfoView != null) {
            profileUserInfoView.setData(this.userId);
        }
        LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> B2 = ((ag4.i) mm4.b.b(ag4.i.class)).B2(this.mYesGameId);
        if (B2 != null) {
            yesGameInfoOuterClass$GetUserGameDefaultRoleRsp = B2.getValue();
        } else {
            yesGameInfoOuterClass$GetUserGameDefaultRoleRsp = null;
        }
        View view2 = this.roleInfoFrame;
        if (view2 != null) {
            fh4.g.o(view2, this.isMaster);
        }
        com.tencent.timi.game.utils.l.b(this.TAG, "initUserData  - defaultAccount=" + yesGameInfoOuterClass$GetUserGameDefaultRoleRsp);
        if (this.showFleetState && (profileItemInTeamView = this.profileItemInTeamView) != null) {
            profileItemInTeamView.m(this.userId);
        }
    }

    private final boolean d1() {
        if (!this.isMaster && this.isCaptain && i1() && !h1()) {
            return true;
        }
        return false;
    }

    private final boolean h1() {
        gh4.e I0;
        gh4.f fVar = (gh4.f) mm4.b.b(gh4.f.class);
        if (fVar != null && (I0 = fVar.I0()) != null) {
            return I0.f5(this.userId);
        }
        return false;
    }

    private final void initView() {
        TextView textView;
        this.profileRelView = findViewById(R.id.f27900hh);
        this.userInfoView = (ProfileUserInfoView) findViewById(R.id.f114956uq);
        this.roleInfoFrame = findViewById(R.id.f776444x);
        this.rootView = (ViewGroup) findViewById(R.id.iet);
        this.smobaRecordView = (ProfileSmobaRecordView) findViewById(R.id.f86494rt);
        this.gameRecordArkFrame = (FrameLayout) findViewById(R.id.vhm);
        this.gameRecordFrame = findViewById(R.id.vhn);
        this.reportButton = findViewById(R.id.f73353tb);
        this.operationFrame = (ViewGroup) findViewById(R.id.zzn);
        this.bottomLinear = (LinearLayout) findViewById(R.id.t9t);
        this.roleNameText = (TextView) findViewById(R.id.f7770453);
        this.roleNameTitle = (TextView) findViewById(R.id.f7771454);
        this.profileAvatarBgView = (RoundImageView) findViewById(R.id.f27880hf);
        this.profileItemInTeamView = (ProfileItemInTeamView) findViewById(R.id.f27890hg);
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            e0(viewGroup);
            fh4.g.e(fh4.g.c(viewGroup, -1), fh4.b.c(15.0f), fh4.b.c(15.0f), 0.0f, 0.0f);
        }
        View view = this.roleInfoFrame;
        if (view != null) {
            fh4.g.f(view, fh4.b.b(10), Color.parseColor("#80F5F5F5"));
        }
        View view2 = this.roleInfoFrame;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        View view3 = this.reportButton;
        if (view3 != null) {
            view3.setOnClickListener(this);
        }
        View findViewById = findViewById(R.id.enf);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        View findViewById2 = findViewById(R.id.f164823az2);
        this.closeButton = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        u1();
        if (!L0() && (textView = this.roleNameText) != null) {
            textView.setCompoundDrawables(null, null, null, null);
        }
        TextView textView2 = this.roleNameTitle;
        if (textView2 != null) {
            textView2.setText(Constants.Business.DEFAULT + B0() + "\u8d26\u53f7");
        }
        k1("initView end ");
    }

    private final void l1() {
        ((ag4.i) mm4.b.b(ag4.i.class)).A1(this.mYesGameId, this.activity, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1(final int second, final long roomId) {
        if (second == 0) {
            TextView textView = this.settingForbiddenButton;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#999999"));
            }
            TextView textView2 = this.settingForbiddenButton;
            if (textView2 != null) {
                textView2.setText(R.string.f2313571m);
            }
        } else {
            TextView textView3 = this.settingForbiddenButton;
            if (textView3 != null) {
                textView3.setTextColor(Color.parseColor("#000000"));
            }
            TextView textView4 = this.settingForbiddenButton;
            if (textView4 != null) {
                textView4.setText(yn4.d.e(second));
            }
        }
        TextView textView5 = this.settingForbiddenButton;
        if (textView5 != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: ul4.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.n1(q.this, roomId, second, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(q this$0, long j3, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new zl4.a(this$0.G, j3, this$0.userId, i3).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(String roleName) {
        if (TextUtils.isEmpty(roleName)) {
            TextView textView = this.roleNameText;
            if (textView != null) {
                textView.setText("\u53bb\u7ed1\u5b9a");
            }
        } else {
            TextView textView2 = this.roleNameText;
            if (textView2 != null) {
                textView2.setText(roleName);
            }
        }
        View view = this.gameRecordFrame;
        if (view != null) {
            fh4.g.o(view, !TextUtils.isEmpty(roleName));
        }
        if (A0() != 101) {
            if (!TextUtils.isEmpty(roleName)) {
                Y0();
            }
            FrameLayout frameLayout = this.gameRecordArkFrame;
            if (frameLayout != null) {
                fh4.g.o(frameLayout, !TextUtils.isEmpty(roleName));
            }
        }
    }

    private final void p1() {
        ProfileRecordArkView profileRecordArkView = this.gameRecordArkView;
        if (profileRecordArkView != null) {
            ViewParent parent = profileRecordArkView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(profileRecordArkView);
            }
        }
        this.gameRecordArkView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(boolean open) {
        this.isAddQQFriendOpen = Boolean.valueOf(open);
        A1();
    }

    private final void u1() {
        int dp2px = (int) ba.dp2px(this.G, 15.0f);
        RoundImageView roundImageView = this.profileAvatarBgView;
        if (roundImageView != null) {
            roundImageView.setmRadius(dp2px, false);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
    }

    public int A0() {
        Long l3 = this.roomId;
        if (l3 != null) {
            l3.longValue();
            return ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId.longValue()).o1();
        }
        return 0;
    }

    @Nullable
    /* renamed from: D0, reason: from getter */
    public final View getReportButton() {
        return this.reportButton;
    }

    @Nullable
    /* renamed from: E0, reason: from getter */
    public final View getRoleInfoFrame() {
        return this.roleInfoFrame;
    }

    @NotNull
    public final String F0() {
        String a16;
        ProfileUserInfoView profileUserInfoView = this.userInfoView;
        if (profileUserInfoView == null || (a16 = profileUserInfoView.a()) == null) {
            return "";
        }
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final View H0() {
        if (i1()) {
            TextView Q0 = Q0(R.string.f2312871f, -16777216, Color.parseColor("#F5F5F5"));
            Q0.setOnClickListener(new View.OnClickListener() { // from class: ul4.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.I0(q.this, view);
                }
            });
            K0(Q0);
            return Q0;
        }
        return null;
    }

    public final void J0(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup viewGroup = this.operationFrame;
        if (viewGroup != null) {
            fh4.g.o(viewGroup, true);
        }
        ViewGroup viewGroup2 = this.operationFrame;
        if (viewGroup2 != null) {
            viewGroup2.addView(view, new ViewGroup.LayoutParams(-1, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K0(@NotNull View... views) {
        Intrinsics.checkNotNullParameter(views, "views");
        LinearLayout linearLayout = this.bottomLinear;
        if (linearLayout != null) {
            fh4.g.o(linearLayout, true);
        }
        LinearLayout linearLayout2 = this.bottomLinear;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
        int length = views.length;
        int dp2px = (int) ba.dp2px(this.G, 6.0f);
        for (int i3 = 0; i3 < length; i3++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            if (i3 != 0) {
                layoutParams.leftMargin = dp2px;
            }
            if (i3 != length - 1) {
                layoutParams.rightMargin = dp2px;
            }
            LinearLayout linearLayout3 = this.bottomLinear;
            if (linearLayout3 != null) {
                linearLayout3.addView(views[i3], layoutParams);
            }
        }
    }

    public boolean L0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M0() {
        Long l3 = this.roomId;
        if (l3 != null) {
            ((fm4.g) mm4.b.b(fm4.g.class)).A(l3.longValue()).Z(this.userId, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N0() {
        Long l3 = this.roomId;
        if (l3 != null) {
            ((fm4.g) mm4.b.b(fm4.g.class)).A(l3.longValue()).r(this.userId, false, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void O0(@NotNull TextView micInvitingTextView) {
        boolean z16;
        Intrinsics.checkNotNullParameter(micInvitingTextView, "micInvitingTextView");
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 != null) {
            CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
            Intrinsics.checkNotNullExpressionValue(E, "getService(ILoginCoreService::class.java).qqUserId");
            if (I0.f5(E) && !I0.Rg(this.userId)) {
                z16 = true;
            } else {
                z16 = false;
            }
            fh4.g.o(micInvitingTextView, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P0(@Nullable TextView microTextView) {
        if (d1()) {
            if (microTextView != null) {
                fh4.g.o(microTextView, true);
            }
            if (microTextView != null) {
                microTextView.setText("\u79fb\u51fa\u9ea6\u4f4d");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TextView Q0(int textResId, int textColor, int backgroundColor) {
        MediumBoldTextView mediumBoldTextView = new MediumBoldTextView(this.G);
        fh4.g.f(mediumBoldTextView, fh4.b.b(30), backgroundColor);
        mediumBoldTextView.setGravity(17);
        mediumBoldTextView.setTextSize(1, 16.0f);
        mediumBoldTextView.setTextColor(textColor);
        mediumBoldTextView.setText(textResId);
        return mediumBoldTextView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: R0, reason: from getter */
    public final QBaseActivity getActivity() {
        return this.activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: S0, reason: from getter */
    public final int getGameIdFromOuter() {
        return this.gameIdFromOuter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Map<String, String> T0() {
        return this.reportParamMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: U0, reason: from getter */
    public final Long getRoomId() {
        return this.roomId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: V0, reason: from getter */
    public final CommonOuterClass$QQUserId getUserId() {
        return this.userId;
    }

    @Nullable
    /* renamed from: W0, reason: from getter */
    protected final IUserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        k1("dismiss start ");
        super.dismiss();
        this.isDismissed = true;
        k1("dismiss end ======");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e1, reason: from getter */
    public final boolean getIsCaptain() {
        return this.isCaptain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f1(@NotNull INearbyAddFriendHelper.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        bm4.a aVar = (bm4.a) mm4.b.b(bm4.a.class);
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = this.userId;
        AppRuntime appRuntime = this.activity.getAppRuntime();
        Intrinsics.checkNotNullExpressionValue(appRuntime, "activity.appRuntime");
        aVar.Q0(commonOuterClass$QQUserId, appRuntime, listener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g1, reason: from getter */
    public final boolean getIsMaster() {
        return this.isMaster;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean i1() {
        Long l3 = this.roomId;
        if (l3 == null) {
            return false;
        }
        l3.longValue();
        gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId.longValue());
        if (K0 == null) {
            return false;
        }
        return K0.q(this.userId);
    }

    public abstract void init();

    @Override // sl4.a
    @Nullable
    public String j0() {
        return F0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j1() {
        CommonOuterClass$QQUserId myUid = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
        Intrinsics.checkNotNullExpressionValue(myUid, "myUid");
        dVar.I3(myUid, new f());
    }

    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!com.tencent.timi.game.utils.o.a()) {
            int id5 = v3.getId();
            if (id5 == R.id.enf) {
                dismiss();
            } else if (id5 == R.id.f164823az2) {
                dismiss();
            } else if (id5 == R.id.f776444x) {
                if (L0()) {
                    B1();
                } else {
                    String x06 = x0();
                    if (!TextUtils.isEmpty(x06)) {
                        com.tencent.timi.game.ui.widget.f.c(x06);
                    }
                }
            } else if (id5 == R.id.f73353tb) {
                if (this.isFromMicPos) {
                    if (this.roomId != null) {
                        ze4.a.c(this.userId.get(), this.roomId.longValue());
                    }
                } else {
                    ze4.a.b(this.userId.get());
                }
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Z0();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        k1("onStart start ");
        super.onStart();
        k1("onStart end ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r1() {
        View view = this.profileRelView;
        if (view != null) {
            view.setBackgroundColor(0);
        }
        this.I = false;
    }

    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        k1("show start ");
        super.show();
        k1("show end ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void v1(@NotNull View view) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.zzv);
        boolean z19 = true;
        if (findViewById != null && findViewById.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        View findViewById2 = view.findViewById(R.id.zzw);
        if (findViewById2 != null && findViewById2.getVisibility() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        View findViewById3 = view.findViewById(R.id.zzu);
        if (findViewById3 != null && findViewById3.getVisibility() == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        View findViewById4 = view.findViewById(R.id.f165002uk1);
        if (findViewById4 != null) {
            if (!z16 && !z17 && !z18) {
                z19 = false;
            }
            fh4.g.o(findViewById4, z19);
        }
    }

    public final void w1(boolean z16) {
        this.isFromMicPos = z16;
    }

    @NotNull
    public String x0() {
        return "";
    }

    public void x1(boolean needShow) {
        TextView textView = (TextView) findViewById(R.id.f83704k_);
        this.settingForbiddenButton = textView;
        if (textView == null) {
            return;
        }
        View findViewById = findViewById(R.id.zzv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.operationReceiveVoice)");
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 == null) {
            return;
        }
        CommonOuterClass$QQUserId selfUid = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        Intrinsics.checkNotNullExpressionValue(selfUid, "selfUid");
        if (I0.f5(selfUid) && !I0.Rg(this.userId)) {
            findViewById.setVisibility(0);
        }
        Long l3 = this.roomId;
        if (l3 != null) {
            long longValue = l3.longValue();
            X0(I0.m0());
            ((pl4.c) mm4.b.b(pl4.c.class)).F1(wl4.c.d(longValue, this.userId), YoloRoomOuterClass$YoloRoomJudgeForbiddenSpeechRsp.class, new h());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int y0(boolean isFriend) {
        if (isFriend) {
            return R.string.f2313471l;
        }
        return R.string.f2313371k;
    }

    protected final void y1(@Nullable IUserInfo iUserInfo) {
        this.userInfo = iUserInfo;
    }

    @Nullable
    /* renamed from: z0, reason: from getter */
    public final View getCloseButton() {
        return this.closeButton;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void z1(boolean isFriend, @Nullable View addFriendButton) {
        this.isUserQQFriend = Boolean.valueOf(isFriend);
        this.addQQFriendView = addFriendButton;
        A1();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull QBaseActivity activity, @NotNull CommonOuterClass$QQUserId userId, boolean z16, boolean z17, @NotNull Map<String, String> reportParamMap, @Nullable Long l3, boolean z18, @NotNull String pageReportName, int i3) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(reportParamMap, "reportParamMap");
        Intrinsics.checkNotNullParameter(pageReportName, "pageReportName");
        this.activity = activity;
        this.userId = userId;
        this.isHeightWrap = z16;
        this.isCaptain = z17;
        this.reportParamMap = reportParamMap;
        this.roomId = l3;
        this.showFleetState = z18;
        this.pageReportName = pageReportName;
        this.gameIdFromOuter = i3;
        this.TAG = "ProfileBaseInfoDialog";
        this.defaultAvatarUrl = "https://cdn.yes.qq.com/tg_profile_dialog_backgroud_ic";
        this.currentTime = System.currentTimeMillis();
        this.eventReceiver = new c();
        this.speakingListener = new j();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"ul4/q$g", "Lag4/i$d;", "", "b", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "selectedDefaultAccount", "a", "", "errorCode", "", "errorMsg", "e", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g implements i.d {
        g() {
        }

        @Override // ag4.i.d
        public void a(@NotNull YesGameInfoOuterClass$GetUserGameDefaultRoleRsp selectedDefaultAccount) {
            Intrinsics.checkNotNullParameter(selectedDefaultAccount, "selectedDefaultAccount");
            q.this.F1(selectedDefaultAccount);
        }

        @Override // ag4.i.d
        public void b() {
        }

        @Override // ag4.i.c
        public void c() {
        }

        @Override // ag4.i.d
        public void e(int errorCode, @Nullable String errorMsg) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"ul4/q$i", "Lag4/i$d;", "", "b", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "selectedDefaultAccount", "a", "", "errorCode", "", "errorMsg", "e", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class i implements i.d {
        i() {
        }

        @Override // ag4.i.d
        public void a(@NotNull YesGameInfoOuterClass$GetUserGameDefaultRoleRsp selectedDefaultAccount) {
            Intrinsics.checkNotNullParameter(selectedDefaultAccount, "selectedDefaultAccount");
            com.tencent.timi.game.utils.l.i(q.this.TAG, "showSmobaAccountSelectDialog bindSucceed ");
            q.this.F1(selectedDefaultAccount);
        }

        @Override // ag4.i.d
        public void b() {
            com.tencent.timi.game.utils.l.i(q.this.TAG, "showSmobaAccountSelectDialog bindCancel ");
        }

        @Override // ag4.i.c
        public void c() {
        }

        @Override // ag4.i.d
        public void e(int errorCode, @Nullable String errorMsg) {
        }
    }

    private final void k1(String value) {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ul4/q$e", "Lcom/tencent/timi/game/utils/IResultListener;", "Lbo4/f;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements IResultListener<bo4.f> {
        e() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable bo4.f result) {
            IUserInfo iUserInfo;
            boolean z16;
            ProfileItemInTeamView profileItemInTeamView;
            q qVar = q.this;
            if (result != null) {
                iUserInfo = result.getCom.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener.KEY_USER_INFO java.lang.String();
            } else {
                iUserInfo = null;
            }
            qVar.y1(iUserInfo);
            q qVar2 = q.this;
            if (result != null) {
                z16 = result.getCanAddQQFriendOpen();
            } else {
                z16 = false;
            }
            qVar2.t1(z16);
            if (!q.this.isDismissed && q.this.showFleetState && (profileItemInTeamView = q.this.profileItemInTeamView) != null) {
                profileItemInTeamView.setData(result, q.this.getUserId(), q.this.getActivity(), q.this.T0(), q.this.A0());
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ul4/q$k", "Lcom/tencent/timi/game/utils/IResultListener;", "Lbo4/c;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class k implements IResultListener<bo4.c> {
        k() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable bo4.c result) {
            String d16;
            if (result != null && (d16 = result.d()) != null) {
                q.this.o1(d16);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"ul4/q$l", "Lcom/tencent/timi/game/utils/IResultListener;", "", "Ltrpc/yes/common/GameDataServerOuterClass$UserDefaultRole;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class l implements IResultListener<List<? extends GameDataServerOuterClass$UserDefaultRole>> {
        l() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable List<GameDataServerOuterClass$UserDefaultRole> result) {
            String str;
            PBStringField pBStringField;
            String str2 = "";
            if (q.this.isDismissed || result == null || !(!result.isEmpty())) {
                q.this.o1("");
                return;
            }
            YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo = result.get(0).game_role_info;
            if (yesGameInfoOuterClass$YesGameRoleInfo != null && (pBStringField = yesGameInfoOuterClass$YesGameRoleInfo.role_name) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (str != null) {
                str2 = str;
            }
            q.this.o1(str2);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
        }
    }
}

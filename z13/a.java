package z13;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.view.tkd.listview.ResourceUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOIntent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.c;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.vas.api.IVasReadPublicAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0019"}, d2 = {"Lz13/a;", "Lcom/tencent/mobileqq/utils/ax;", "", "uin", "", "args", "", UserInfo.SEX_FEMALE, "argsUin", "G", "H", "Landroid/content/Intent;", "intent", "", "I", "", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "cc", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends ax {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BaseQQAppInterface app, Context cc5) {
        super(app, cc5);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(cc5, "cc");
    }

    private final void F(String uin, Map<String, String> args) {
        ExtensionInfo H;
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return;
        }
        Manager manager = this.f307436a.getManager(QQManagerFactory.FRIENDS_MANAGER);
        RichStatus richStatus = null;
        FriendsManager friendsManager = manager instanceof FriendsManager ? (FriendsManager) manager : null;
        if (friendsManager != null && (H = friendsManager.H(uin)) != null) {
            richStatus = c.e(H);
        }
        Intent intent = new Intent();
        intent.putExtra(SquareJSConst.Params.PARAMS_RICH_STATUS, richStatus);
        intent.putExtra("public_fragment_class", "com.tencent.mobileqq.signature.SignTextEditFragment");
        intent.setClass(topActivity, QPublicFragmentActivity.class);
        topActivity.startActivityForResult(intent, -1);
    }

    private final void G(String argsUin) {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return;
        }
        if (TextUtils.isEmpty(argsUin)) {
            argsUin = AppConstants.QQ_VIP_UIN;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(topActivity, IPublicAccountDetailActivity.ROUTE_NAME);
        activityURIRequest.extra().putString("uin", argsUin);
        activityURIRequest.extra().putBoolean("fromQGamePub", true);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    private final Intent I(Intent intent, int[] args) {
        intent.putExtra("open_chatfragment", true);
        intent.addFlags(67108864);
        if (args != null) {
            for (int i3 : args) {
                if (i3 == 1) {
                    intent.putExtra("open_chatfragment_withanim", true);
                } else if (i3 == 2) {
                    intent.addFlags(268435456);
                }
            }
        }
        return new AIOIntent(intent);
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        if (!h().equals("vasvip") || !this.f307440e.equals("kuikly")) {
            return false;
        }
        Map<String, String> args = URLUtil.getArgumentsFromURL(this.f307438c);
        Intrinsics.checkNotNullExpressionValue(args, "args");
        if (!args.isEmpty()) {
            String str = args.get("type");
            String str2 = args.get("uin");
            String str3 = args.get("busi");
            if (Intrinsics.areEqual(str3, IPublicAccountWebviewPlugin.SCHEME)) {
                if (str != null) {
                    int hashCode = str.hashCode();
                    if (hashCode != -257760259) {
                        if (hashCode != 94005370) {
                            if (hashCode == 926934164 && str.equals("history")) {
                                if (str2 == null) {
                                    str2 = "";
                                }
                                H(str2);
                            }
                        } else if (str.equals("brief")) {
                            if (str2 == null) {
                                str2 = "";
                            }
                            G(str2);
                        }
                    } else if (str.equals("personalsign")) {
                        if (str2 == null) {
                            str2 = "";
                        }
                        F(str2, args);
                    }
                }
            } else if (Intrinsics.areEqual(str3, "personalsign")) {
                if (str2 == null) {
                    str2 = "";
                }
                F(str2, args);
            }
        }
        return true;
    }

    private final void H(String argsUin) {
        try {
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity == null) {
                return;
            }
            Triple triple = new Triple(AppConstants.QQ_VIP_UIN, "u_ll1P7qg5B912tgUWBNyIFA", Integer.valueOf(R.string.f1764531a));
            String str = AppConstants.QQ_YELLOW_VIP_UIN;
            if (Intrinsics.areEqual(argsUin, str)) {
                triple = new Triple(str, "u_LybjswVdDqCbj0fzTbsQSQ", Integer.valueOf(R.string.f17642318));
            }
            String str2 = AppConstants.QQ_VIP_READ_UIN;
            if (Intrinsics.areEqual(argsUin, str2)) {
                triple = new Triple(str2, IVasReadPublicAccount.READ_UID, Integer.valueOf(R.string.f1764631b));
            }
            Intent intent = new Intent();
            intent.setComponent(SplashActivity.getAliasComponent(topActivity));
            Intent I = I(intent, new int[]{1});
            I.putExtra("shouldreport", true);
            I.putExtra("has_unread_msg", false);
            I.putExtra("jump_from", 1);
            I.setClass(topActivity, ChatActivity.class);
            I.putExtra("uin", (String) triple.getFirst());
            I.putExtra("key_peerId", (String) triple.getSecond());
            I.putExtra("uintype", 1008);
            I.putExtra("uinname", ResourceUtil.getString(((Number) triple.getThird()).intValue()));
            I.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 1);
            I.putExtra("aio_msg_source", 0);
            topActivity.startActivity(I);
        } catch (Exception e16) {
            QLog.e("QVipRenewalAction", 1, "exception", e16);
        }
    }
}

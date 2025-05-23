package tc1;

import QQService.EVIPSPEC;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.VipTypeParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.bp;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.theme.SkinEngine;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.ThemeImageWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 V2\u00020\u0001:\u0001\u001eB#\u0012\b\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\u0010S\u001a\u0004\u0018\u00010R\u0012\u0006\u0010K\u001a\u00020\n\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J>\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0004J6\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0014J\b\u0010!\u001a\u00020\u001fH\u0014J\b\u0010\"\u001a\u00020\u001fH\u0014J%\u0010'\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0014\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010+\u001a\u0004\u0018\u00010\n2\u0006\u0010*\u001a\u00020)J\u0018\u0010/\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010\nJ\u000e\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0004R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\"\u0010K\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010O\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010F\u001a\u0004\bM\u0010H\"\u0004\bN\u0010J\u00a8\u0006W"}, d2 = {"Ltc1/l;", "Lcom/tencent/mobileqq/activity/contacts/base/c;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/activity/contacts/friend/BuddyListFriends$a;", "tag", "Lcom/tencent/mobileqq/data/VipTypeParam;", "vipTypeParam", "", "strStatus", "name", "signature", "Landroid/view/View;", "convertView", "u", "status", "Lcom/tencent/mobileqq/phonecontact/api/IPhoneContactService;", "contactMgr", "y", "B", "icon", "v", "groupPosition", "childPosition", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View$OnClickListener;", "listener", "a", "", "f", tl.h.F, "e", com.tencent.luggage.wxa.c8.c.G, "", "Lcom/tencent/widget/SwipRightMenuBuilder$SwipRightMenuItem;", "menus", "g", "(I[Lcom/tencent/widget/SwipRightMenuBuilder$SwipRightMenuItem;)V", "Lcom/tencent/mobileqq/activity/contacts/base/c$c;", "t", "w", "Lcom/tencent/image/URLImageView;", "urlImageView", "url", BdhLogUtil.LogTag.Tag_Conn, "layoutType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/app/FriendsManager;", "k", "Lcom/tencent/mobileqq/app/FriendsManager;", "getMFriendMsanger", "()Lcom/tencent/mobileqq/app/FriendsManager;", "setMFriendMsanger", "(Lcom/tencent/mobileqq/app/FriendsManager;)V", "mFriendMsanger", "Lcom/tencent/mobileqq/richstatus/StatusManager;", "l", "Lcom/tencent/mobileqq/richstatus/StatusManager;", "getMStatusManager", "()Lcom/tencent/mobileqq/richstatus/StatusManager;", "setMStatusManager", "(Lcom/tencent/mobileqq/richstatus/StatusManager;)V", "mStatusManager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mLayoutType", DomainData.DOMAIN_NAME, "Ljava/lang/String;", "getUid", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "uid", "o", "getUin", "setUin", "uin", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/content/Context;", "ctx", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)V", "p", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class l extends com.tencent.mobileqq.activity.contacts.base.c {

    /* renamed from: q, reason: collision with root package name */
    private static final int[] f435841q = {R.string.a9d, R.string.a9e};

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f435842r = {R.drawable.cjb, R.drawable.cjb};

    /* renamed from: s, reason: collision with root package name */
    private static final int[] f435843s = {R.id.eqg, R.id.eqg};

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private FriendsManager mFriendMsanger;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private StatusManager mStatusManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mLayoutType;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String uid;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private String uin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(QQAppInterface qQAppInterface, Context context, String uid) {
        super(qQAppInterface, context, null);
        Intrinsics.checkNotNullParameter(uid, "uid");
        Manager manager = this.f181503c.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        this.mFriendMsanger = (FriendsManager) manager;
        Manager manager2 = this.f181503c.getManager(QQManagerFactory.STATUS_MANAGER);
        Intrinsics.checkNotNull(manager2, "null cannot be cast to non-null type com.tencent.mobileqq.richstatus.StatusManager");
        this.mStatusManager = (StatusManager) manager2;
        this.uid = uid;
        String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(uid);
        Intrinsics.checkNotNullExpressionValue(uinFromUid, "api(IRelationNTUinAndUid\u2026.java).getUinFromUid(uid)");
        this.uin = uinFromUid;
        z();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.excute(new Runnable() { // from class: tc1.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.r(l.this);
                }
            }, 16, null, true);
        } else {
            this.mFriendMsanger.H(this.uin);
        }
    }

    private final void B(BuddyListFriends.a tag, String strStatus) {
        tag.C.setVisibility(0);
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(this.uid, "NTBuddyListFriend");
        if (Utils.G(onlineStatusSimpleInfoWithUid != null ? onlineStatusSimpleInfoWithUid.f0() : null)) {
            tag.N = false;
            tag.C.setVisibility(8);
        }
        if (onlineStatusSimpleInfoWithUid != null && ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).bindOnlineStatusView(this.f181503c, onlineStatusSimpleInfoWithUid, tag.P)) {
            tag.P.setVisibility(0);
            strStatus = "";
        } else {
            tag.P.setVisibility(8);
        }
        if (!TextUtils.isEmpty(strStatus)) {
            tag.C.setText('[' + strStatus + ']');
            tag.C.setVisibility(0);
            return;
        }
        tag.C.setText("");
        tag.C.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(l this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mFriendMsanger.H(this$0.uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(BuddyListFriends.a tag, boolean z16) {
        MutualMarkIconsView mutualMarkIconsView;
        Intrinsics.checkNotNullParameter(tag, "$tag");
        if (tag.J != null && (mutualMarkIconsView = tag.K) != null) {
            tag.J.setVisibility((!z16 || mutualMarkIconsView.d() <= 0) ? 8 : 0);
        } else {
            QLog.d("NTBuddyListFriend", 1, "tag.splitView == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(BuddyListFriends.a tag, boolean z16) {
        MutualMarkIconsView mutualMarkIconsView;
        Intrinsics.checkNotNullParameter(tag, "$tag");
        if (tag.J != null && (mutualMarkIconsView = tag.K) != null) {
            tag.J.setVisibility((!z16 || mutualMarkIconsView.d() <= 0) ? 8 : 0);
        } else {
            QLog.d("NTBuddyListFriend", 1, "tag.splitView == null || tag.mutualMarkIconsView == null");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
    
        if (r6.isServiceEnabled(r7) != false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void u(BuddyListFriends.a tag, VipTypeParam vipTypeParam, String strStatus, String name, String signature, View convertView) {
        String plainText;
        if (!AppSetting.f99565y) {
            return;
        }
        StringBuilder sb5 = tag.L;
        boolean z16 = false;
        if (sb5 == null) {
            sb5 = new StringBuilder(24);
        } else {
            sb5.delete(0, sb5.length());
        }
        if (TextUtils.isEmpty(strStatus)) {
            strStatus = tag.P.a().toString();
        }
        sb5.append(name);
        sb5.append(".");
        sb5.append(strStatus);
        sb5.append(".");
        EVIPSPEC E_SP_SUPERVIP = EVIPSPEC.E_SP_SUPERVIP;
        Intrinsics.checkNotNullExpressionValue(E_SP_SUPERVIP, "E_SP_SUPERVIP");
        if (!vipTypeParam.isServiceEnabled(E_SP_SUPERVIP)) {
            EVIPSPEC E_SP_QQVIP = EVIPSPEC.E_SP_QQVIP;
            Intrinsics.checkNotNullExpressionValue(E_SP_QQVIP, "E_SP_QQVIP");
        }
        sb5.append("QQ\u4f1a\u5458");
        sb5.append(".");
        if (!TextUtils.isEmpty(signature)) {
            sb5.append(signature);
            sb5.append(".");
        }
        if (!TextUtils.isEmpty(tag.K.D)) {
            sb5.append(tag.K.D.toString());
        }
        ExtensionInfo I = this.mFriendMsanger.I(this.uin, false);
        boolean z17 = (I == null || TextUtils.isEmpty(I.feedContent)) ? false : true;
        RichStatus e16 = I != null ? com.tencent.mobileqq.richstatus.c.e(I) : null;
        if (e16 != null && e16 != RichStatus.getEmptyStatus() && !e16.isEmpty()) {
            z16 = true;
        }
        if (z17) {
            Intrinsics.checkNotNull(I);
            if (I.feedTime > I.richTime || !z16) {
                plainText = I.feedContent;
                if (!TextUtils.isEmpty(plainText)) {
                    sb5.append(".");
                    sb5.append(plainText);
                }
                if (convertView != null) {
                    return;
                }
                convertView.setContentDescription(sb5);
                return;
            }
        }
        plainText = e16 != null ? e16.getPlainText() : "";
        if (!TextUtils.isEmpty(plainText)) {
        }
        if (convertView != null) {
        }
    }

    private final int x() {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(this.uid, "NTBuddyListFriend");
        if (onlineStatusSimpleInfoWithUid == null) {
            return 0;
        }
        return com.tencent.mobileqq.friend.status.b.a(onlineStatusSimpleInfoWithUid.u(), onlineStatusSimpleInfoWithUid.z());
    }

    private final void z() {
        int i3;
        this.f181501a = b(this.f181504d);
        SpecialCareInfo O = this.mFriendMsanger.O(this.uin);
        if (O != null && O.globalSwitch != 0) {
            i3 = this.f181502b | 1;
        } else {
            i3 = this.f181502b & (-2);
        }
        this.f181502b = i3;
    }

    public final void A(int layoutType) {
        this.mLayoutType = layoutType;
    }

    public final void C(URLImageView urlImageView, String url) {
        Intrinsics.checkNotNullParameter(urlImageView, "urlImageView");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = urlImageView.getWidth();
        obtain.mRequestHeight = urlImageView.getHeight();
        Drawable drawable = this.f181504d.getResources().getDrawable(R.drawable.f162390gm2);
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
        drawable2.setTag(com.tencent.mobileqq.urldrawable.a.c(urlImageView.getWidth(), urlImageView.getHeight(), ViewUtils.dip2px(2.0f)));
        drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
        urlImageView.setImageDrawable(drawable2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:1|(18:5|(1:7)|9|10|(1:12)|13|(1:61)(1:17)|18|(1:20)|21|(1:23)(1:60)|24|(9:27|(2:29|(2:31|(1:33)))|35|(1:37)(1:58)|38|(1:40)(1:57)|(2:(3:43|(1:45)(1:52)|46)(1:53)|(1:48))(2:54|(1:56))|49|50)|59|(0)(0)|(0)(0)|49|50)|62|63|64|65|10|(0)|13|(1:15)|61|18|(0)|21|(0)(0)|24|(9:27|(0)|35|(0)(0)|38|(0)(0)|(0)(0)|49|50)|59|(0)(0)|(0)(0)|49|50) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01d2, code lost:
    
        if (r7.isServiceEnabled(r10) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00a7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00a8, code lost:
    
        com.tencent.qphone.base.util.QLog.e("NTBuddyListFriend", 1, r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b1, code lost:
    
        com.tencent.qphone.base.util.QLog.e("NTBuddyListFriend", 1, r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0045, code lost:
    
        if (((com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends.a) r0).M == false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0196  */
    @Override // com.tencent.mobileqq.activity.contacts.base.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View a(int groupPosition, int childPosition, View convertView, ViewGroup parent, View.OnClickListener listener) {
        final BuddyListFriends.a a16;
        View createView;
        View findViewById;
        boolean z16;
        boolean simpleUISwitch;
        NTVasSimpleInfo vasSimpleInfoWithUid;
        VipTypeParam vipTypeParam;
        Unit unit;
        EVIPSPEC E_SP_SUPERQQ;
        Intrinsics.checkNotNullParameter(parent, "parent");
        IRuntimeService runtimeService = this.f181503c.getRuntimeService(IPhoneContactService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "mApp.getRuntimeService(\n\u2026ssConstant.MAIN\n        )");
        IPhoneContactService iPhoneContactService = (IPhoneContactService) runtimeService;
        if (convertView != null && (convertView.getTag() instanceof BuddyListFriends.a)) {
            if (convertView.getTag() instanceof BuddyListFriends.a) {
                Object tag = convertView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends.BuddyChildTag");
            }
            Object tag2 = convertView.getTag();
            Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends.BuddyChildTag");
            BuddyListFriends.a aVar = (BuddyListFriends.a) tag2;
            ((IVipColorName) QRoute.api(IVipColorName.class)).clearTextColorGradient(aVar.f181511h);
            aVar.f181512i.setCompoundDrawables(null, null);
            a16 = aVar;
            createView = convertView;
            findViewById = createView.findViewById(R.id.v4v);
            if (findViewById != null) {
                findViewById.setBackground(this.f181504d.getResources().getDrawable(R.drawable.jiv));
            }
            z();
            a16.f181513m = this.uid;
            String str = this.uin;
            a16.f187114d = str;
            a16.K.k(this.f181503c, str, 3, true);
            int x16 = x();
            a16.N = false;
            z16 = x16 != 0 || x16 == 6;
            if ((iPhoneContactService.getUIBits() & 1) != 1) {
                a16.f187116f.setEnableMask(z16);
                a16.N = z16;
            }
            String y16 = y(x16, iPhoneContactService);
            B(a16, y16);
            w(a16);
            a16.G.setVisibility(8);
            com.tencent.relation.common.bean.nameservice.a aVar2 = new com.tencent.relation.common.bean.nameservice.a();
            aVar2.d(this.uid);
            String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar2);
            a16.f181511h.setText(nameWithConfig);
            simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
            ff.i iVar = new ff.i();
            VipTypeParam vipTypeParam2 = new VipTypeParam(0, 0, 0, 0, 15, null);
            vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(this.uid, "NTBuddyListFriend");
            if (vasSimpleInfoWithUid == null) {
                iVar.f307794a = this.uin;
                iVar.f307795b = vasSimpleInfoWithUid.nameplateVipType;
                iVar.f307796c = vasSimpleInfoWithUid.grayNameplateFlag;
                int i3 = vasSimpleInfoWithUid.qqVipInfo;
                iVar.f307797d = i3;
                int i16 = vasSimpleInfoWithUid.superVipInfo;
                iVar.f307799f = i16;
                int i17 = vasSimpleInfoWithUid.bigClubInfo;
                iVar.f307800g = i17;
                vipTypeParam = new VipTypeParam(i3, vasSimpleInfoWithUid.superQqInfo, i16, i17);
            } else {
                vipTypeParam = vipTypeParam2;
            }
            if (!z16 && !simpleUISwitch) {
                E_SP_SUPERQQ = EVIPSPEC.E_SP_SUPERQQ;
                Intrinsics.checkNotNullExpressionValue(E_SP_SUPERQQ, "E_SP_SUPERQQ");
                if (!vipTypeParam.isServiceEnabled(E_SP_SUPERQQ)) {
                    EVIPSPEC E_SP_BIGCLUB = EVIPSPEC.E_SP_BIGCLUB;
                    Intrinsics.checkNotNullExpressionValue(E_SP_BIGCLUB, "E_SP_BIGCLUB");
                    if (!vipTypeParam.isServiceEnabled(E_SP_BIGCLUB)) {
                        EVIPSPEC E_SP_SUPERVIP = EVIPSPEC.E_SP_SUPERVIP;
                        Intrinsics.checkNotNullExpressionValue(E_SP_SUPERVIP, "E_SP_SUPERVIP");
                        if (!vipTypeParam.isServiceEnabled(E_SP_SUPERVIP)) {
                            EVIPSPEC E_SP_QQVIP = EVIPSPEC.E_SP_QQVIP;
                            Intrinsics.checkNotNullExpressionValue(E_SP_QQVIP, "E_SP_QQVIP");
                        }
                    }
                }
                ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(a16.f181511h, vasSimpleInfoWithUid == null ? vasSimpleInfoWithUid.getUin() : null, true);
                if (simpleUISwitch) {
                    ff.X(a16.f181511h, iVar, this.f181503c, this.f181504d, new ff.f() { // from class: tc1.i
                        @Override // com.tencent.mobileqq.utils.ff.f
                        public final void a(boolean z17) {
                            l.s(BuddyListFriends.a.this, z17);
                        }
                    });
                } else {
                    a16.J.setVisibility(8);
                    a16.f181511h.setCompoundDrawablesWithIntrinsicBounds(0, 0);
                }
                if (simpleUISwitch) {
                    if (vasSimpleInfoWithUid != null) {
                        String uin = vasSimpleInfoWithUid.getUin();
                        long j3 = vasSimpleInfoWithUid.namePlateOfKingGameId;
                        int i18 = vasSimpleInfoWithUid.namePlateOfKingDan;
                        Boolean bool = vasSimpleInfoWithUid.namePlateOfKingDanDisplatSwitch;
                        IGameCardManager.a aVar3 = new IGameCardManager.a(uin, j3, i18, bool != null ? bool.booleanValue() : false, vasSimpleInfoWithUid.gameCardId);
                        aVar3.f312733a = "list";
                        VipGrayConfigHelper vipGrayConfigHelper = VipGrayConfigHelper.getsInstance();
                        URLImageView uRLImageView = a16.I;
                        EVIPSPEC E_SP_SUPERVIP2 = EVIPSPEC.E_SP_SUPERVIP;
                        Intrinsics.checkNotNullExpressionValue(E_SP_SUPERVIP2, "E_SP_SUPERVIP");
                        vipGrayConfigHelper.updateNamePlateOfKingIconView(uRLImageView, vipTypeParam.isServiceEnabled(E_SP_SUPERVIP2), vasSimpleInfoWithUid.namePlateOfKingLoginTime, aVar3, new VipGrayConfigHelper.c() { // from class: tc1.j
                            @Override // com.tencent.mobileqq.vas.VipGrayConfigHelper.c
                            public final void a(boolean z17) {
                                l.t(BuddyListFriends.a.this, z17);
                            }
                        });
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        a16.I.setVisibility(8);
                        a16.J.setVisibility(8);
                    }
                } else if (a16.I.getVisibility() != 8) {
                    a16.I.setVisibility(8);
                    a16.J.setVisibility(8);
                }
                in2.a.a(a16.f181511h.getContext(), a16.f181511h, this.uin);
                a16.f181512i.setVisibility(0);
                n(createView, (groupPosition << 16) | childPosition, a16, listener);
                u(a16, vipTypeParam, y16, nameWithConfig, "", createView);
                l(createView, 1, this.uin);
                return createView;
            }
            a16.f181511h.setTextColor(com.tencent.mobileqq.activity.contacts.base.c.c(this.f181504d, QUITokenResUtil.getResId(R.color.skin_black_theme_version2, R.color.qui_common_text_primary)));
            ((IVipColorName) QRoute.api(IVipColorName.class)).clearTextColorGradient(a16.f181511h);
            if (simpleUISwitch) {
            }
            if (simpleUISwitch) {
            }
            in2.a.a(a16.f181511h.getContext(), a16.f181511h, this.uin);
            a16.f181512i.setVisibility(0);
            n(createView, (groupPosition << 16) | childPosition, a16, listener);
            u(a16, vipTypeParam, y16, nameWithConfig, "", createView);
            l(createView, 1, this.uin);
            return createView;
        }
        View inflate = LayoutInflater.from(this.f181504d).inflate(QUITokenResUtil.getResId(R.layout.f167805i2, R.layout.f167806e42), (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout");
        a16 = ((FriendItemLayout) inflate).a();
        Intrinsics.checkNotNullExpressionValue(a16, "leftView as FriendItemLayout).init()");
        a16.E.setBackgroundResource(R.drawable.f162389gm1);
        a16.F.setImageDrawable(this.f181504d.getResources().getDrawable(R.drawable.f162390gm2));
        createView = this.f181501a.createView(this.f181504d, inflate, a16, -1);
        a16.M = true;
        createView.setTag(a16);
        v(inflate.findViewById(R.id.icon));
        findViewById = createView.findViewById(R.id.v4v);
        if (findViewById != null) {
        }
        z();
        a16.f181513m = this.uid;
        String str2 = this.uin;
        a16.f187114d = str2;
        a16.K.k(this.f181503c, str2, 3, true);
        int x162 = x();
        a16.N = false;
        if (x162 != 0) {
        }
        if ((iPhoneContactService.getUIBits() & 1) != 1) {
        }
        String y162 = y(x162, iPhoneContactService);
        B(a16, y162);
        w(a16);
        a16.G.setVisibility(8);
        com.tencent.relation.common.bean.nameservice.a aVar22 = new com.tencent.relation.common.bean.nameservice.a();
        aVar22.d(this.uid);
        String nameWithConfig2 = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar22);
        a16.f181511h.setText(nameWithConfig2);
        simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        ff.i iVar2 = new ff.i();
        VipTypeParam vipTypeParam22 = new VipTypeParam(0, 0, 0, 0, 15, null);
        vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(this.uid, "NTBuddyListFriend");
        if (vasSimpleInfoWithUid == null) {
        }
        if (!z16) {
            E_SP_SUPERQQ = EVIPSPEC.E_SP_SUPERQQ;
            Intrinsics.checkNotNullExpressionValue(E_SP_SUPERQQ, "E_SP_SUPERQQ");
            if (!vipTypeParam.isServiceEnabled(E_SP_SUPERQQ)) {
            }
            ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(a16.f181511h, vasSimpleInfoWithUid == null ? vasSimpleInfoWithUid.getUin() : null, true);
            if (simpleUISwitch) {
            }
            if (simpleUISwitch) {
            }
            in2.a.a(a16.f181511h.getContext(), a16.f181511h, this.uin);
            a16.f181512i.setVisibility(0);
            n(createView, (groupPosition << 16) | childPosition, a16, listener);
            u(a16, vipTypeParam, y162, nameWithConfig2, "", createView);
            l(createView, 1, this.uin);
            return createView;
        }
        a16.f181511h.setTextColor(com.tencent.mobileqq.activity.contacts.base.c.c(this.f181504d, QUITokenResUtil.getResId(R.color.skin_black_theme_version2, R.color.qui_common_text_primary)));
        ((IVipColorName) QRoute.api(IVipColorName.class)).clearTextColorGradient(a16.f181511h);
        if (simpleUISwitch) {
        }
        if (simpleUISwitch) {
        }
        in2.a.a(a16.f181511h.getContext(), a16.f181511h, this.uin);
        a16.f181512i.setVisibility(0);
        n(createView, (groupPosition << 16) | childPosition, a16, listener);
        u(a16, vipTypeParam, y162, nameWithConfig2, "", createView);
        l(createView, 1, this.uin);
        return createView;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected int[] e() {
        return f435842r;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected int[] f() {
        return f435843s;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected void g(int pos, SwipRightMenuBuilder.SwipRightMenuItem[] menus) {
        Intrinsics.checkNotNullParameter(menus, "menus");
        if (menus.length <= 0) {
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(this.uid, "NTBuddyListFriend");
        int i3 = 0;
        if (menus.length > 0 && friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.f() >= 0) {
            if ((this.f181502b & 1) == 1) {
                menus[0].menuId = 0;
            } else {
                menus[0].menuId = 1;
            }
            menus[0].menuType = 0;
            i3 = 1;
        }
        while (i3 < menus.length) {
            SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = menus[i3];
            swipRightMenuItem.menuId = -1;
            swipRightMenuItem.menuType = -1;
            i3++;
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected int[] h() {
        return f435841q;
    }

    protected final void v(View icon) {
        if (icon instanceof DynamicAvatarView) {
            DynamicAvatarView dynamicAvatarView = (DynamicAvatarView) icon;
            if (dynamicAvatarView.K == null) {
                dynamicAvatarView.K = new ThemeImageWrapper();
            }
            dynamicAvatarView.K.setSupportMaskView(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String w(c.C7154c t16) {
        String str;
        boolean z16;
        RichStatus richStatus;
        boolean z17;
        boolean z18;
        String str2;
        int roundToInt;
        byte[] s16;
        Intrinsics.checkNotNullParameter(t16, "t");
        BuddyListFriends.a aVar = (BuddyListFriends.a) t16;
        Object obj = aVar.f181513m;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        String str3 = (String) obj;
        com.tencent.qqnt.ntrelation.zoneinfo.bean.c zoneSimpleInfoWithUid = ((IZoneInfoService) QRoute.api(IZoneInfoService.class)).getZoneSimpleInfoWithUid(str3, "NTBuddyListFriend");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(str3, "NTBuddyListFriend");
        if (zoneSimpleInfoWithUid == null || (str = zoneSimpleInfoWithUid.b()) == null) {
            str = "";
        }
        boolean z19 = !TextUtils.isEmpty(str);
        if (friendsSimpleInfoWithUid != null && (s16 = friendsSimpleInfoWithUid.s()) != null) {
            if (!(s16.length == 0)) {
                z16 = true;
                String str4 = null;
                if (z16) {
                    richStatus = null;
                } else {
                    c.b bVar = this.f181507g;
                    richStatus = com.tencent.mobileqq.richstatus.c.g(Long.valueOf(friendsSimpleInfoWithUid.t()), friendsSimpleInfoWithUid.s(), Boolean.valueOf((bVar != null ? bVar.getMScrollState() : 0) != 0));
                }
                z17 = (richStatus != null || richStatus == RichStatus.getEmptyStatus() || richStatus.isEmpty()) ? false : true;
                if (z17) {
                    if (!TextUtils.isEmpty(richStatus != null ? richStatus.actionText : null)) {
                        z18 = true;
                        if (!z19 && zoneSimpleInfoWithUid != null && friendsSimpleInfoWithUid != null && (zoneSimpleInfoWithUid.f() > friendsSimpleInfoWithUid.t() || !z17)) {
                            str2 = zoneSimpleInfoWithUid.b();
                            aVar.f181512i.setCompoundDrawables(null, null);
                            if (zoneSimpleInfoWithUid.j() == 2) {
                                aVar.D.setVisibility(0);
                                if (!TextUtils.isEmpty(zoneSimpleInfoWithUid.e())) {
                                    bp.a(aVar.D, zoneSimpleInfoWithUid.e(), this.f181504d.getResources().getDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                                } else {
                                    aVar.D.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                                }
                                aVar.E.setVisibility(8);
                                aVar.F.setVisibility(8);
                            } else {
                                aVar.E.setVisibility(0);
                                aVar.E.setBackgroundResource(zoneSimpleInfoWithUid.j() == 1 ? R.drawable.f162391gm3 : R.drawable.f162389gm1);
                                aVar.F.setVisibility(zoneSimpleInfoWithUid.c() ? 0 : 8);
                                if (zoneSimpleInfoWithUid.c() && !TextUtils.isEmpty(zoneSimpleInfoWithUid.e())) {
                                    URLImageView uRLImageView = aVar.F;
                                    Intrinsics.checkNotNullExpressionValue(uRLImageView, "tag.ivQZonePhoto");
                                    C(uRLImageView, zoneSimpleInfoWithUid.e());
                                }
                                aVar.D.setVisibility(8);
                                aVar.D.setImageDrawable(null);
                            }
                        } else {
                            if (z18) {
                                if (richStatus != null) {
                                    richStatus.enableSummaryCached = friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.f() >= 0;
                                }
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f181504d.getResources(), this.mStatusManager.K(richStatus != null ? richStatus.actionId : 0, 200));
                                int a16 = (int) al.a(this.f181504d, 12.0f);
                                roundToInt = MathKt__MathJVMKt.roundToInt(((bitmapDrawable.getIntrinsicWidth() * 1.0f) / bitmapDrawable.getIntrinsicHeight()) * a16);
                                bitmapDrawable.setBounds(0, 0, roundToInt, a16);
                                aVar.f181512i.setCompoundDrawables(bitmapDrawable, null);
                            } else if (!z17) {
                                richStatus = RichStatus.getEmptyStatus();
                                aVar.f181512i.setCompoundDrawables(null, null);
                            }
                            String actionAndData = richStatus != null ? richStatus.getActionAndData() : null;
                            String plainText = richStatus != null ? richStatus.getPlainText() : null;
                            aVar.F.setVisibility(8);
                            aVar.E.setVisibility(8);
                            aVar.D.setVisibility(8);
                            aVar.D.setImageDrawable(null);
                            str4 = actionAndData;
                            str2 = plainText;
                        }
                        if (zoneSimpleInfoWithUid != null || TextUtils.isEmpty(zoneSimpleInfoWithUid.b())) {
                            aVar.F.setVisibility(8);
                            aVar.E.setVisibility(8);
                        }
                        aVar.f181512i.setExtendText(str4, 1);
                        aVar.f181512i.setText(str2);
                        return str2;
                    }
                }
                z18 = false;
                if (!z19) {
                }
                if (z18) {
                }
                if (richStatus != null) {
                }
                if (richStatus != null) {
                }
                aVar.F.setVisibility(8);
                aVar.E.setVisibility(8);
                aVar.D.setVisibility(8);
                aVar.D.setImageDrawable(null);
                str4 = actionAndData;
                str2 = plainText;
                if (zoneSimpleInfoWithUid != null) {
                }
                aVar.F.setVisibility(8);
                aVar.E.setVisibility(8);
                aVar.f181512i.setExtendText(str4, 1);
                aVar.f181512i.setText(str2);
                return str2;
            }
        }
        z16 = false;
        String str42 = null;
        if (z16) {
        }
        if (richStatus != null) {
        }
        if (z17) {
        }
        z18 = false;
        if (!z19) {
        }
        if (z18) {
        }
        if (richStatus != null) {
        }
        if (richStatus != null) {
        }
        aVar.F.setVisibility(8);
        aVar.E.setVisibility(8);
        aVar.D.setVisibility(8);
        aVar.D.setImageDrawable(null);
        str42 = actionAndData;
        str2 = plainText;
        if (zoneSimpleInfoWithUid != null) {
        }
        aVar.F.setVisibility(8);
        aVar.E.setVisibility(8);
        aVar.f181512i.setExtendText(str42, 1);
        aVar.f181512i.setText(str2);
        return str2;
    }

    private final String y(int status, IPhoneContactService contactMgr) {
        String offlineTipsConfig;
        String offlineTipsConfig2;
        BusinessHandler businessHandler = this.f181503c.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendListHandler");
        FriendListHandler friendListHandler = (FriendListHandler) businessHandler;
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(this.uid, "NTBuddyListFriend");
        long j3 = 10;
        switch (status) {
            case 0:
                if (onlineStatusSimpleInfoWithUid != null && onlineStatusSimpleInfoWithUid.B() != 0) {
                    j3 = onlineStatusSimpleInfoWithUid.B();
                }
                if ((contactMgr.getUIBits() & 2) == 2 && j3 == 1) {
                    offlineTipsConfig = HardCodeUtil.qqStr(R.string.f171674k44);
                } else {
                    offlineTipsConfig = friendListHandler.getOfflineTipsConfig(j3);
                }
                return offlineTipsConfig == null ? this.f181504d.getString(R.string.hps) : offlineTipsConfig;
            case 1:
                return this.f181504d.getString(R.string.hpd);
            case 2:
                return this.f181504d.getString(R.string.hpg);
            case 3:
                return this.f181504d.getString(R.string.hpu);
            case 4:
            case 8:
                return ac.P(onlineStatusSimpleInfoWithUid != null ? onlineStatusSimpleInfoWithUid.C() : 0);
            case 5:
            default:
                if (onlineStatusSimpleInfoWithUid != null && onlineStatusSimpleInfoWithUid.B() != 0) {
                    j3 = onlineStatusSimpleInfoWithUid.B();
                }
                if ((contactMgr.getUIBits() & 2) == 2 && j3 == 1) {
                    offlineTipsConfig2 = HardCodeUtil.qqStr(R.string.f171674k44);
                } else {
                    offlineTipsConfig2 = friendListHandler.getOfflineTipsConfig(j3);
                }
                return offlineTipsConfig2 == null ? this.f181504d.getString(R.string.hps) : offlineTipsConfig2;
            case 6:
                return "";
            case 7:
                return this.f181504d.getString(R.string.hpm);
        }
    }
}

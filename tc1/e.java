package tc1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.bp;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService;
import com.tencent.theme.SkinEngine;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0088\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u001e\u0089\u00013B=\u0012\u0006\u0010\u007f\u001a\u00020~\u0012\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001\u0012\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u0001\u0012\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010a\u0012\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010E\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J'\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J \u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\r2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0014\u0010\u0015\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010$\u001a\u00020\u001dH\u0016J\u0010\u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020\u001dH\u0016J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001dH\u0016J\b\u0010)\u001a\u00020\u001dH\u0016J$\u0010-\u001a\u0004\u0018\u00010\u00182\u0006\u0010$\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010\u00182\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\u0010\u00100\u001a\u00020/2\u0006\u0010$\u001a\u00020\u001dH\u0016J\u0018\u00101\u001a\u00020/2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001dH\u0016J\u0018\u00102\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001dH\u0016J\u0010\u00104\u001a\u00020\u001d2\b\u00103\u001a\u0004\u0018\u00010\u000fJ\u0018\u00108\u001a\u0004\u0018\u00010\u000f2\u0006\u00105\u001a\u00020\u000f2\u0006\u00107\u001a\u000206J\u0010\u00109\u001a\u00020/2\u0006\u0010 \u001a\u00020\u0018H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016R\u0016\u0010=\u001a\u0004\u0018\u00010;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u0004\u0018\u00010E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR6\u0010P\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00060I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010X\u001a\u00020Q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR*\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010CR\u0016\u0010d\u001a\u0004\u0018\u00010a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010k\u001a\u00020h8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010n\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\"\u0010t\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010C\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001c\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010{\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010}\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010m\u00a8\u0006\u008a\u0001"}, d2 = {"Ltc1/e;", "Lcom/tencent/mobileqq/activity/contacts/alphabet/a;", "Lcom/tencent/mobileqq/activity/contacts/base/c$b;", "Landroid/view/View$OnLongClickListener;", "", "y", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "letterCategory", "", "", "k", "(Ljava/util/List;)[Ljava/lang/Object;", "Ljava/util/ArrayList;", "j", "", "uids", "Ltc1/l;", "o", "t", "arrayList", "v", DomainData.DOMAIN_NAME, "p", "Landroid/view/View;", "footerView", "u", HippyTKDListViewAdapter.X, "i", "", "a", "Lcom/tencent/widget/AbsListView;", "view", HippyTKDListViewAdapter.SCROLL_STATE, "onScrollStateChanged", "getCount", "position", "getItem", "", "getItemId", "getItemViewType", "getViewTypeCount", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "getDividerLayout", "", "isDividerView", "needHideDivider", "configDividerView", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "uid", "Lcom/tencent/mobileqq/activity/contacts/friend/BuddyListFriends$a;", "tag", "l", NodeProps.ON_LONG_CLICK, "destroy", "Lcom/tencent/mobileqq/richstatus/StatusManager;", "Lcom/tencent/mobileqq/richstatus/StatusManager;", "mStatusManager", "Lcom/tencent/mobileqq/app/FriendsManager;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/FriendsManager;", "mFriendMsanger", "D", "I", "mScrollState", "Landroid/view/View$OnClickListener;", "E", "Landroid/view/View$OnClickListener;", "mOnClickListener", "Ljava/util/LinkedHashMap;", UserInfo.SEX_FEMALE, "Ljava/util/LinkedHashMap;", "getMIndexedFriends", "()Ljava/util/LinkedHashMap;", "setMIndexedFriends", "(Ljava/util/LinkedHashMap;)V", "mIndexedFriends", "", "G", "[I", "getMGroupItemCount", "()[I", "setMGroupItemCount", "([I)V", "mGroupItemCount", "H", "[Ljava/lang/String;", "getMIndexes", "()[Ljava/lang/String;", "setMIndexes", "([Ljava/lang/String;)V", "mIndexes", "dpToPiexl12", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar;", "J", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar;", "currentIndexView", "K", "Landroid/view/View;", "mFooterView", "Ltc1/e$c;", "L", "Ltc1/e$c;", "itemLongClickListener", "M", "Z", "mCanChildAction", "N", "getFriendSize", "()I", "setFriendSize", "(I)V", "friendSize", "P", "Ljava/util/List;", "mLetterCategoryCacheInfo", "Lcom/tencent/mobileqq/activity/contacts/friend/b;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/activity/contacts/friend/b;", "mFirstNotifyFriendDataCallback", BdhLogUtil.LogTag.Tag_Req, "isFirstLoadData", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/widget/XListView;", "attachedListView", "indexView", "listener", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/widget/XListView;Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar;Landroid/view/View$OnClickListener;)V", ExifInterface.LATITUDE_SOUTH, "b", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e extends com.tencent.mobileqq.activity.contacts.alphabet.a implements c.b, View.OnLongClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final FriendsManager mFriendMsanger;

    /* renamed from: D, reason: from kotlin metadata */
    private int mScrollState;

    /* renamed from: E, reason: from kotlin metadata */
    private final View.OnClickListener mOnClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    private LinkedHashMap<String, List<l>> mIndexedFriends;

    /* renamed from: G, reason: from kotlin metadata */
    private int[] mGroupItemCount;

    /* renamed from: H, reason: from kotlin metadata */
    private String[] mIndexes;

    /* renamed from: I, reason: from kotlin metadata */
    private final int dpToPiexl12;

    /* renamed from: J, reason: from kotlin metadata */
    private final IndexBar currentIndexView;

    /* renamed from: K, reason: from kotlin metadata */
    private View mFooterView;

    /* renamed from: L, reason: from kotlin metadata */
    private final c itemLongClickListener;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mCanChildAction;

    /* renamed from: N, reason: from kotlin metadata */
    private int friendSize;

    /* renamed from: P, reason: from kotlin metadata */
    private List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> mLetterCategoryCacheInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    private com.tencent.mobileqq.activity.contacts.friend.b mFirstNotifyFriendDataCallback;

    /* renamed from: R, reason: from kotlin metadata */
    private volatile boolean isFirstLoadData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final StatusManager mStatusManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Ltc1/e$b;", "Lcom/tencent/mobileqq/adapter/k;", "", "i", "I", "getType", "()I", "setType", "(I)V", "type", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "a", "()Landroid/widget/TextView;", "setTvDivider", "(Landroid/widget/TextView;)V", "tvDivider", "Landroid/view/View;", "convertView", "<init>", "(Landroid/view/View;)V", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends com.tencent.mobileqq.adapter.k {

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int type;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private TextView tvDivider;

        public b(View convertView) {
            Intrinsics.checkNotNullParameter(convertView, "convertView");
            this.type = 1;
            View findViewById = convertView.findViewById(R.id.k8u);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.tvDivider = (TextView) findViewById;
        }

        /* renamed from: a, reason: from getter */
        public final TextView getTvDivider() {
            return this.tvDivider;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Ltc1/e$c;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_LONG_CLICK, "Ljava/lang/ref/WeakReference;", "Ltc1/e;", "d", "Ljava/lang/ref/WeakReference;", "mRef", "adapterNT", "<init>", "(Ltc1/e;)V", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements View.OnLongClickListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<e> mRef;

        public c(e adapterNT) {
            Intrinsics.checkNotNullParameter(adapterNT, "adapterNT");
            this.mRef = new WeakReference<>(adapterNT);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            e eVar = this.mRef.get();
            if (eVar != null) {
                return eVar.onLongClick(v3);
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, QQAppInterface app, XListView xListView, IndexBar indexBar, View.OnClickListener onClickListener) {
        super(context, app, xListView, true);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        this.mIndexedFriends = new LinkedHashMap<>();
        this.mGroupItemCount = new int[0];
        this.mIndexes = new String[0];
        this.mCanChildAction = true;
        this.mLetterCategoryCacheInfo = new ArrayList();
        this.isFirstLoadData = true;
        this.f181451h = context;
        this.mOnClickListener = onClickListener;
        this.currentIndexView = indexBar;
        Manager manager = app.getManager(QQManagerFactory.STATUS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.richstatus.StatusManager");
        this.mStatusManager = (StatusManager) manager;
        Manager manager2 = app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager2, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        this.mFriendMsanger = (FriendsManager) manager2;
        this.dpToPiexl12 = (int) al.a(this.f181451h, 12.0f);
        this.itemLongClickListener = new c(this);
    }

    private final ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> j(List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> letterCategory) {
        String f16;
        CharSequence trim;
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> arrayList = new ArrayList<>();
        if (letterCategory.isEmpty()) {
            return arrayList;
        }
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar : letterCategory) {
            if (bVar != null && (f16 = bVar.f()) != null) {
                trim = StringsKt__StringsKt.trim((CharSequence) f16);
                if (!TextUtils.isEmpty(trim.toString())) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("NTAlphabetFriendAdapter", 2, "notifyDataSetChanged out ThreadManager");
        }
        this$0.x();
        this$0.i();
        super.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(e this$0, Object[] objArr) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("NTAlphabetFriendAdapter", 2, "notifyDataSetChanged out ThreadManager");
        }
        Object obj = objArr[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.LinkedHashMap<kotlin.String?, kotlin.collections.List<com.tencent.mobileqq.friend.alphabet.NTBuddyListFriend>>");
        this$0.mIndexedFriends = (LinkedHashMap) obj;
        Object obj2 = objArr[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.IntArray");
        this$0.mGroupItemCount = (int[]) obj2;
        Object obj3 = objArr[2];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.String?>");
        this$0.mIndexes = (String[]) obj3;
        Object obj4 = objArr[3];
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
        this$0.friendSize = ((Integer) obj4).intValue();
        this$0.y();
        this$0.x();
        super.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.activity.contacts.friend.b bVar = this$0.mFirstNotifyFriendDataCallback;
        if (bVar != null) {
            bVar.a();
        }
    }

    private final void t() {
        XListView xListView = this.f181449e;
        if (xListView == null) {
            return;
        }
        int childCount = xListView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Object tag = this.f181449e.getChildAt(i3).getTag();
            if (tag != null && (tag instanceof BuddyListFriends.a)) {
                BuddyListFriends.a aVar = (BuddyListFriends.a) tag;
                if (TextUtils.isEmpty(aVar.f181512i.getText().toString())) {
                    Object obj = aVar.f181513m;
                    if (obj instanceof String) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        l((String) obj, aVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
    }

    private final void y() {
        IndexBar indexBar = this.currentIndexView;
        if (indexBar != null) {
            if (this.friendSize >= 5) {
                indexBar.setLetters(this.mIndexes);
            } else {
                indexBar.setLetters(null);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c.b
    /* renamed from: a, reason: from getter */
    public int getMScrollState() {
        return this.mScrollState;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public void configDividerView(View view, int position) {
        Intrinsics.checkNotNullParameter(view, "view");
        int binarySearch = Arrays.binarySearch(this.mGroupItemCount, position);
        if (binarySearch < 0) {
            binarySearch = (-(binarySearch + 1)) - 1;
        }
        if (binarySearch >= this.mIndexes.length || binarySearch < 0 || !(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        view.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), 0, 0);
        String str = this.mIndexes[binarySearch];
        if (Intrinsics.areEqual(str, "\u2605")) {
            ((TextView) view).setText(HardCodeUtil.qqStr(R.string.jd8));
        } else {
            ((TextView) view).setText(str);
        }
        ColorStateList colorStateList = this.f181451h.getResources().getColorStateList(R.color.qui_common_brand_standard);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "mContext.resources.getCo\u2026ui_common_brand_standard)");
        TextView textView2 = (TextView) view;
        textView2.setTextColor(colorStateList);
        if (ThemeUtil.isNowThemeIsSimple(MobileQQ.sMobileQQ.peekAppRuntime(), false, null)) {
            textView2.setTextColor(ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null) ? -1 : -16777216);
        }
        Resources resources = view.getResources();
        if (QUITokenResUtil.useQUIToken() && resources != null) {
            view.setBackground(resources.getDrawable(R.drawable.qui_common_fill_light_primary_bg, null));
        }
        IndexBar indexBar = this.currentIndexView;
        if (indexBar != null) {
            indexBar.setChooseIndex(binarySearch);
        }
        textView2.setTypeface(Typeface.SANS_SERIF);
    }

    @Override // com.tencent.mobileqq.activity.contacts.alphabet.a
    public void destroy() {
        super.destroy();
        this.f181451h = null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<l> list;
        if (this.mGroupItemCount.length == 0 || this.mIndexedFriends.size() == 0) {
            return 0;
        }
        String[] strArr = this.mIndexes;
        if (strArr.length == 0 || (list = this.mIndexedFriends.get(strArr[strArr.length - 1])) == null) {
            return 0;
        }
        return this.mGroupItemCount[r1.length - 1] + list.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        int binarySearch = Arrays.binarySearch(this.mGroupItemCount, position);
        if (binarySearch >= 0) {
            return null;
        }
        List<l> list = this.mIndexedFriends.get(this.mIndexes[(-(binarySearch + 1)) - 1]);
        if (list != null) {
            return list.get((position - this.mGroupItemCount[r0]) - 1);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        return Arrays.binarySearch(this.mGroupItemCount, position) < 0 ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        int binarySearch = Arrays.binarySearch(this.mGroupItemCount, position);
        if (getItemViewType(position) == 1) {
            int i3 = (-(binarySearch + 1)) - 1;
            List<l> list = this.mIndexedFriends.get(this.mIndexes[i3]);
            int i16 = (position - this.mGroupItemCount[i3]) - 1;
            if (list == null || i16 >= list.size()) {
                return convertView;
            }
            l lVar = list.get(i16);
            boolean z16 = lVar instanceof l;
            if (z16) {
                lVar.A(1);
            }
            View a16 = lVar == null ? null : lVar.a(0, position, convertView, parent, this.mOnClickListener);
            if (a16 == null || !z16) {
                return convertView;
            }
            Object tag = a16.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends.BuddyChildTag");
            c((BuddyListFriends.a) tag, null);
            View.OnClickListener onClickListener = this.mOnClickListener;
            if (onClickListener != null) {
                a16.setOnClickListener(onClickListener);
            }
            return a16;
        }
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f181451h).inflate(QUITokenResUtil.getResId(R.layout.f167802i1, R.layout.f167803e40), parent, false);
            convertView.setTag(new b(convertView));
        } else {
            convertView.setBackground(this.f181451h.getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg));
        }
        if (!(convertView.getTag() instanceof b)) {
            View inflate = LayoutInflater.from(this.f181451h).inflate(QUITokenResUtil.getResId(R.layout.f167802i1, R.layout.f167803e40), parent, false);
            inflate.setTag(new b(inflate));
            convertView = inflate;
        }
        Object tag2 = convertView.getTag();
        Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type com.tencent.mobileqq.friend.alphabet.NTAlphabetFriendAdapter.FriendViewHolder");
        b bVar = (b) tag2;
        String valueOf = String.valueOf(this.mIndexes[binarySearch]);
        if (!TextUtils.isEmpty(valueOf)) {
            if (Intrinsics.areEqual(valueOf, "\u2605")) {
                bVar.getTvDivider().setText(HardCodeUtil.qqStr(R.string.jd8));
            } else {
                bVar.getTvDivider().setText(valueOf);
            }
        }
        if (!AppSetting.f99565y) {
            return convertView;
        }
        TextView tvDivider = bVar.getTvDivider();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.f181451h.getString(R.string.aud);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.string.divider_tip)");
        String lowerCase = valueOf.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        String format = String.format(string, Arrays.copyOf(new Object[]{lowerCase}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        tvDivider.setContentDescription(format);
        ViewCompat.setAccessibilityHeading(bVar.getTvDivider(), true);
        return convertView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public boolean isDividerView(int position) {
        return Arrays.binarySearch(this.mGroupItemCount, position) >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String l(String uid, BuddyListFriends.a tag) {
        boolean z16;
        RichStatus richStatus;
        boolean z17;
        boolean z18;
        String str;
        byte[] s16;
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(tag, "tag");
        String str2 = null;
        if (this.mStatusManager == null || this.f181451h == null) {
            return null;
        }
        com.tencent.qqnt.ntrelation.zoneinfo.bean.c zoneSimpleInfoWithUid = ((IZoneInfoService) QRoute.api(IZoneInfoService.class)).getZoneSimpleInfoWithUid(uid, "NTAlphabetFriendAdapter");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uid, "NTAlphabetFriendAdapter");
        boolean z19 = (zoneSimpleInfoWithUid == null || TextUtils.isEmpty(zoneSimpleInfoWithUid.b())) ? false : true;
        if (friendsSimpleInfoWithUid != null && (s16 = friendsSimpleInfoWithUid.s()) != null) {
            if (!(s16.length == 0)) {
                z16 = true;
                if (z16) {
                    richStatus = null;
                } else {
                    richStatus = com.tencent.mobileqq.richstatus.c.g(friendsSimpleInfoWithUid != null ? Long.valueOf(friendsSimpleInfoWithUid.t()) : null, friendsSimpleInfoWithUid != null ? friendsSimpleInfoWithUid.s() : null, Boolean.valueOf(this.mScrollState != 0));
                }
                z17 = (richStatus != null || richStatus == RichStatus.getEmptyStatus() || richStatus.isEmpty()) ? false : true;
                if (z17) {
                    if (!TextUtils.isEmpty(richStatus != null ? richStatus.actionText : null)) {
                        z18 = true;
                        if (!z19 && zoneSimpleInfoWithUid != null && friendsSimpleInfoWithUid != null && (zoneSimpleInfoWithUid.f() > friendsSimpleInfoWithUid.t() || !z17)) {
                            str = zoneSimpleInfoWithUid.b();
                            tag.f181512i.setCompoundDrawables(null, null);
                            if (zoneSimpleInfoWithUid.j() == 2) {
                                tag.D.setVisibility(0);
                                if (!TextUtils.isEmpty(zoneSimpleInfoWithUid.e())) {
                                    bp.a(tag.D, zoneSimpleInfoWithUid.e(), this.f181451h.getResources().getDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                                } else {
                                    tag.D.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                                }
                                tag.E.setVisibility(8);
                                tag.F.setVisibility(8);
                            } else {
                                tag.E.setVisibility(0);
                                tag.E.setBackgroundResource(zoneSimpleInfoWithUid.j() == 1 ? R.drawable.f162391gm3 : R.drawable.f162389gm1);
                                tag.F.setVisibility(zoneSimpleInfoWithUid.c() ? 0 : 8);
                                tag.D.setVisibility(8);
                                tag.D.setImageDrawable(null);
                            }
                        } else {
                            if (z18) {
                                if (richStatus != null) {
                                    richStatus.enableSummaryCached = friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.f() >= 0;
                                }
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f181451h.getResources(), this.mStatusManager.K(richStatus != null ? richStatus.actionId : 0, 200));
                                int i3 = this.dpToPiexl12;
                                bitmapDrawable.setBounds(0, 0, Math.round(((bitmapDrawable.getIntrinsicWidth() * 1.0f) / bitmapDrawable.getIntrinsicHeight()) * i3), i3);
                                tag.f181512i.setCompoundDrawables(bitmapDrawable, null);
                            } else if (!z17) {
                                richStatus = RichStatus.getEmptyStatus();
                                tag.f181512i.setCompoundDrawables(null, null);
                            }
                            String actionAndData = richStatus != null ? richStatus.getActionAndData() : null;
                            String plainText = richStatus != null ? richStatus.getPlainText() : null;
                            tag.F.setVisibility(8);
                            tag.E.setVisibility(8);
                            tag.D.setVisibility(8);
                            tag.D.setImageDrawable(null);
                            str2 = actionAndData;
                            str = plainText;
                        }
                        if (zoneSimpleInfoWithUid != null || TextUtils.isEmpty(zoneSimpleInfoWithUid.b())) {
                            tag.F.setVisibility(8);
                            tag.E.setVisibility(8);
                        }
                        tag.f181512i.setExtendText(str2, 1);
                        tag.f181512i.setText(str);
                        return str;
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
                tag.F.setVisibility(8);
                tag.E.setVisibility(8);
                tag.D.setVisibility(8);
                tag.D.setImageDrawable(null);
                str2 = actionAndData;
                str = plainText;
                if (zoneSimpleInfoWithUid != null) {
                }
                tag.F.setVisibility(8);
                tag.E.setVisibility(8);
                tag.f181512i.setExtendText(str2, 1);
                tag.f181512i.setText(str);
                return str;
            }
        }
        z16 = false;
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
        tag.F.setVisibility(8);
        tag.E.setVisibility(8);
        tag.D.setVisibility(8);
        tag.D.setImageDrawable(null);
        str2 = actionAndData;
        str = plainText;
        if (zoneSimpleInfoWithUid != null) {
        }
        tag.F.setVisibility(8);
        tag.E.setVisibility(8);
        tag.f181512i.setExtendText(str2, 1);
        tag.f181512i.setText(str);
        return str;
    }

    public final List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> n() {
        return this.mLetterCategoryCacheInfo;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public boolean needHideDivider(View view, int position) {
        Intrinsics.checkNotNullParameter(view, "view");
        return this.mIndexes.length <= 0;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return false;
    }

    @Override // com.tencent.mobileqq.activity.contacts.alphabet.a, com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mScrollState = scrollState;
        super.onScrollStateChanged(view, scrollState);
        if (scrollState == 0) {
            t();
        }
        if (scrollState != 0) {
            ApngImage.pauseByTag(3);
        }
        if (scrollState == 0) {
            ApngImage.playByTag(3);
        }
    }

    public final void p() {
        final Object[] k3 = k(this.mLetterCategoryCacheInfo);
        if (k3 != null && k3.length >= 4) {
            if (k3.length >= 4) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: tc1.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.r(e.this, k3);
                    }
                });
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("NTAlphabetFriendAdapter", 2, "constructHashStruct result == null!");
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: tc1.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.q(e.this);
                }
            });
        }
        if (this.isFirstLoadData) {
            this.isFirstLoadData = false;
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: tc1.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.s(e.this);
                }
            });
        }
        List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> list = this.mLetterCategoryCacheInfo;
        if (list == null || list.isEmpty()) {
            com.tencent.mobileqq.activity.contacts.report.d.f181714a.i(RelationListReqType.LETTER, 1);
        }
    }

    public final void u(View footerView) {
        this.mFooterView = footerView;
    }

    public final void v(ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "arrayList");
        this.mLetterCategoryCacheInfo = arrayList;
        ThreadManagerV2.excute(new Runnable() { // from class: tc1.a
            @Override // java.lang.Runnable
            public final void run() {
                e.w(e.this);
            }
        }, 16, null, true);
    }

    public final void x() {
        View view;
        XListView xListView = this.f181449e;
        if (xListView == null || this.f181451h == null || xListView.getFooterViewsCount() <= 0 || (view = this.mFooterView) == null) {
            return;
        }
        TextView textView = view != null ? (TextView) view.findViewById(R.id.f164303rl) : null;
        int i3 = this.friendSize;
        if (i3 > 0) {
            if (textView == null) {
                return;
            }
            textView.setText(this.f181451h.getResources().getString(R.string.a__, Integer.valueOf(i3)));
        } else {
            if (textView == null) {
                return;
            }
            textView.setText("");
        }
    }

    public final void i() {
        this.friendSize = 0;
        this.mIndexedFriends.clear();
        this.mGroupItemCount = new int[0];
        this.mIndexes = new String[0];
    }

    private final Object[] k(List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> letterCategory) {
        String f16;
        ArrayList<l> o16;
        if (letterCategory == null) {
            return null;
        }
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> j3 = j(letterCategory);
        if (j3.isEmpty()) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int[] iArr = new int[j3.size()];
        ArrayList arrayList = new ArrayList();
        iArr[0] = 0;
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> it = j3.iterator();
        int i3 = 0;
        int i16 = 1;
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b next = it.next();
            if (next != null && next.c() != null && (f16 = next.f()) != null && (o16 = o(next.c())) != null && (!o16.isEmpty())) {
                arrayList.add(f16);
                linkedHashMap.put(f16, o16);
                if (i16 < j3.size()) {
                    iArr[i16] = o16.size() + iArr[i16 - 1] + 1;
                }
                if (next.d() != 9999) {
                    i3 += o16.size();
                }
                i16++;
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return new Object[]{linkedHashMap, iArr, array, Integer.valueOf(i3)};
    }

    private final ArrayList<l> o(ArrayList<String> uids) {
        if (uids == null) {
            return null;
        }
        ArrayList<l> arrayList = new ArrayList<>();
        Iterator<String> it = uids.iterator();
        while (it.hasNext()) {
            String uid = it.next();
            if (!TextUtils.isEmpty(uid)) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
                Context context = this.f181451h;
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                arrayList.add(new l(qQAppInterface, context, uid));
            }
        }
        return arrayList;
    }

    public final int m(String c16) {
        if (c16 == null) {
            return -1;
        }
        char charAt = c16.charAt(0);
        String[] strArr = this.mIndexes;
        if (strArr == null) {
            return -1;
        }
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            String str = this.mIndexes[i3];
            Character valueOf = str != null ? Character.valueOf(str.charAt(0)) : null;
            if (valueOf != null && valueOf.charValue() != '\u2605') {
                if (charAt == '#') {
                    i3 = this.mIndexes.length - 1;
                    break;
                }
                if (Intrinsics.compare((int) charAt, (int) valueOf.charValue()) <= 0) {
                    break;
                }
            }
            i3++;
        }
        if (i3 >= 0) {
            return this.mGroupItemCount[i3];
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public int getDividerLayout() {
        return QUITokenResUtil.getResId(R.layout.f168254qf, R.layout.fg8);
    }
}

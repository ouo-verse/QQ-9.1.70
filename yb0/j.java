package yb0;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Outline;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSRecordShareUserBean;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenCloseEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.qqcircle.utils.cc;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.api.IGuildShareToFeedApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.util.GuildForwardUtilKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.multishare.action.ShareActionLine;
import com.tencent.mobileqq.multishare.api.IMultiShareApi;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.share.api.ShareActionSheetClickListener;
import com.tencent.mobileqq.share.api.ShareConfig;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.relation.entitys.FriendsWrapper;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$ShareItem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 i2\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010;\u001a\u000206\u00a2\u0006\u0004\bg\u0010hJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\rH\u0002J\u0016\u0010\u0013\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0016\u0010\u0014\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0016\u0010\u0015\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0016\u0010\u0016\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0006\u0010#\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\bJ\u000e\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%J\u0006\u0010(\u001a\u00020\u0006J\u0006\u0010)\u001a\u00020\u0004J\u000e\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*J\u0010\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010-J\u0016\u00102\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\u0006\u00101\u001a\u000200J\u0010\u00103\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0017\u0010;\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R$\u0010C\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010K\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010S\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010[\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR(\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010e\u00a8\u0006j"}, d2 = {"Lyb0/j;", "", "Lcom/tencent/mobileqq/multishare/action/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "isSelected", "", "N", "", "uin", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "o", "emId", "", QQBrowserActivity.APP_PARAM, DomainData.DOMAIN_NAME, "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "sendUsers", "l", "B", BdhLogUtil.LogTag.Tag_Conn, "p", "Lcom/tencent/mobileqq/share/api/ShareConfig;", "shareConfig", "Lcom/tencent/mobileqq/multishare/action/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "id", "y", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "t", ReportConstant.COSTREPORT_PREFIX, "r", "j", "u", "Landroid/content/Context;", "context", "L", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/content/Intent;", "forwardIntent", UserInfo.SEX_FEMALE, "Lj92/d;", "titleCreator", "E", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "k", "M", "a", "Lcom/tencent/mobileqq/share/api/ShareConfig;", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "b", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "w", "()Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "shareInfo", "Landroid/content/DialogInterface$OnDismissListener;", "c", "Landroid/content/DialogInterface$OnDismissListener;", "getOnDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "H", "(Landroid/content/DialogInterface$OnDismissListener;)V", "onDismissListener", "Landroid/content/DialogInterface$OnCancelListener;", "d", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "G", "(Landroid/content/DialogInterface$OnCancelListener;)V", "onCancelListener", "Landroid/content/DialogInterface$OnShowListener;", "e", "Landroid/content/DialogInterface$OnShowListener;", "getOnShowListener", "()Landroid/content/DialogInterface$OnShowListener;", "I", "(Landroid/content/DialogInterface$OnShowListener;)V", "onShowListener", "Lcom/tencent/mobileqq/share/api/ShareActionSheetClickListener;", "f", "Lcom/tencent/mobileqq/share/api/ShareActionSheetClickListener;", "v", "()Lcom/tencent/mobileqq/share/api/ShareActionSheetClickListener;", "K", "(Lcom/tencent/mobileqq/share/api/ShareActionSheetClickListener;)V", "shareActionSheetClickListener", "g", "Ljava/util/List;", "getSelectedUserList", "()Ljava/util/List;", "J", "(Ljava/util/List;)V", "selectedUserList", "Lcom/tencent/mobileqq/multishare/api/IMultiShareApi;", tl.h.F, "Lcom/tencent/mobileqq/multishare/api/IMultiShareApi;", "mShareInstance", "<init>", "(Lcom/tencent/mobileqq/share/api/ShareConfig;Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;)V", "i", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class j {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final List<Integer> f449980j;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShareConfig shareConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleShareInfo shareInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DialogInterface.OnDismissListener onDismissListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DialogInterface.OnCancelListener onCancelListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DialogInterface.OnShowListener onShowListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ShareActionSheetClickListener shareActionSheetClickListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends com.tencent.mobileqq.multishare.action.c> selectedUserList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IMultiShareApi mShareInstance;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J$\u0010\n\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bJ\u0014\u0010\u000f\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0011R\u0014\u0010\u001f\u001a\u00020\u00188\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00188\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00188\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010 \u00a8\u0006%"}, d2 = {"Lyb0/j$a;", "", "", "Lcom/tencent/mobileqq/data/RecentUser;", "recentShareUserList", "", "b", "srcList", "", "needMoveForwardList", "d", "", "isNeedAddMutual", "Lj92/e;", "c", "e", "DT_VALUE_CHANNEL_PREFIX", "Ljava/lang/String;", "DT_VALUE_FALSE", "DT_VALUE_GROUP_PREFIX", "DT_VALUE_MUTUAL_FOLLOW", "DT_VALUE_TRUE", "DT_VALUE_UIN_PREFIX", "", "", "FULL_SCREEN_CLOSE_OPERATION_LIST", "Ljava/util/List;", "", "PREVIEW_CORNER_RADIUS", UserInfo.SEX_FEMALE, "TAG", "UIN_TYPE_FRIEND", "I", "UIN_TYPE_GROUP", "UIN_TYPE_GUILD", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: yb0.j$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: yb0.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C11599a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((RecentUser) t17).lastmsgtime), Long.valueOf(((RecentUser) t16).lastmsgtime));
                return compareValues;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"yb0/j$a$b", "Lj92/e;", "", "Lcom/tencent/mobileqq/data/RecentUser;", "recentShareUserList", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: yb0.j$a$b */
        /* loaded from: classes5.dex */
        public static final class b implements j92.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f449989a;

            b(boolean z16) {
                this.f449989a = z16;
            }

            @Override // j92.e
            public void a(@NotNull List<RecentUser> recentShareUserList) {
                Intrinsics.checkNotNullParameter(recentShareUserList, "recentShareUserList");
                if (this.f449989a && com.tencent.biz.qqcircle.immersive.utils.a.c()) {
                    j.INSTANCE.b(recentShareUserList);
                }
                j.INSTANCE.e(recentShareUserList);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(List<RecentUser> recentShareUserList) {
            List<Entity> g16 = p.f450005a.g();
            List<QFSRecordShareUserBean> c16 = cc.c();
            if (!g16.isEmpty() && !c16.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Entity entity : g16) {
                    if (entity instanceof FriendsWrapper) {
                        for (QFSRecordShareUserBean qFSRecordShareUserBean : c16) {
                            FriendsWrapper friendsWrapper = (FriendsWrapper) entity;
                            if (Intrinsics.areEqual(friendsWrapper.uin, qFSRecordShareUserBean.getShareUin())) {
                                RecentUser recentUser = new RecentUser(friendsWrapper.uin, 10008);
                                recentUser.lastmsgtime = qFSRecordShareUserBean.getShareTimestamp();
                                if (!QCircleCommonUtil.isFriend(friendsWrapper.uin)) {
                                    recentUser.displayName = friendsWrapper.name;
                                    recentUser.lastmsgtime = qFSRecordShareUserBean.getShareTimestamp() / 1000;
                                    arrayList.add(recentUser);
                                }
                            }
                        }
                    }
                }
                IRecentForwardUserProxy recentForwardCache = ((IRecentUserProxyService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRecentUserProxyService.class, "")).getRecentForwardCache();
                Intrinsics.checkNotNullExpressionValue(recentForwardCache, "appRuntime.getRuntimeSer\u2026     ).recentForwardCache");
                List<RecentUser> recentList = recentForwardCache.getRecentList(true, true, false);
                ArrayList arrayList2 = new ArrayList();
                for (RecentUser recentUser2 : recentList) {
                    for (RecentUser recentUser3 : recentShareUserList) {
                        if (Intrinsics.areEqual(recentUser2.uin, recentUser3.uin)) {
                            arrayList2.add(recentUser3);
                        }
                    }
                }
                recentShareUserList.removeAll(arrayList2);
                if (arrayList.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new C11599a());
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RecentUser recentUser4 = (RecentUser) it.next();
                    if (arrayList2.isEmpty()) {
                        arrayList2.add(recentUser4);
                        break;
                    }
                    int size = arrayList2.size();
                    int i3 = 0;
                    int i16 = -1;
                    while (true) {
                        if (i3 < size) {
                            if (recentUser4.lastmsgtime > ((RecentUser) arrayList2.get(i3)).lastmsgtime) {
                                break;
                            }
                            i16 = i3;
                            i3++;
                        } else {
                            i3 = i16;
                            break;
                        }
                    }
                    if (i3 != -1) {
                        arrayList2.add(i3 + 1, recentUser4);
                    }
                }
                recentShareUserList.addAll(0, arrayList2);
                return;
            }
            QLog.d("QFSMultiShareManager", 1, "[addMutualFollow] empty.");
        }

        private final void d(List<RecentUser> srcList, List<String> needMoveForwardList) {
            Object obj;
            if (srcList.size() != 0 && needMoveForwardList.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (String str : needMoveForwardList) {
                    Iterator it = srcList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (Intrinsics.areEqual(((RecentUser) obj).uin, str)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    RecentUser recentUser = (RecentUser) obj;
                    if (recentUser != null) {
                        arrayList.add(recentUser);
                    }
                }
                srcList.removeAll(arrayList);
                srcList.addAll(0, arrayList);
            }
        }

        @NotNull
        public final j92.e c(boolean isNeedAddMutual) {
            return new b(isNeedAddMutual);
        }

        public final void e(@NotNull List<RecentUser> recentShareUserList) {
            Intrinsics.checkNotNullParameter(recentShareUserList, "recentShareUserList");
            List<String> qfsRecentShareUsersList = cc.b();
            Intrinsics.checkNotNullExpressionValue(qfsRecentShareUsersList, "qfsRecentShareUsersList");
            d(recentShareUserList, qfsRecentShareUsersList);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001e\u0010\u0013\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0015\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\u0019"}, d2 = {"yb0/j$b", "Lj92/b;", "Lorg/json/JSONObject;", QQCustomArkDialogUtil.META_DATA, "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "c", "Lcom/tencent/mobileqq/multishare/action/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "f", "Lcom/tencent/mobileqq/multishare/action/c;", "", "isSelected", "a", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "sendUsers", "", "leaveMsg", "e", "chosenUsers", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements j92.b {
        b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final SharePublishGuildFeedParam c(JSONObject metaData) {
            JSONObject jSONObject;
            try {
            } catch (JSONException e16) {
                QLog.e("QFSMultiShareManager", 1, "forwardToGuildFeed error", e16);
            }
            if (metaData.has("video")) {
                jSONObject = metaData.optJSONObject("video");
                if (jSONObject == null) {
                    String jumpUrl = jSONObject.optString("jumpURL");
                    String title = jSONObject.optString("title");
                    String pcJumpUrl = jSONObject.optString("pcJumpUrl");
                    String coverUrl = jSONObject.optString("preview");
                    Intrinsics.checkNotNullExpressionValue(title, "title");
                    Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
                    Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
                    Intrinsics.checkNotNullExpressionValue(pcJumpUrl, "pcJumpUrl");
                    return new SharePublishGuildFeedParam.QCircleTypeParam(title, coverUrl, jumpUrl, pcJumpUrl);
                }
                return GuildForwardUtilKt.j(metaData, null, 1, null);
            }
            jSONObject = null;
            if (jSONObject == null) {
            }
        }

        @Override // j92.b
        public void a(@NotNull com.tencent.mobileqq.multishare.action.c item, boolean isSelected) {
            String str;
            String str2;
            int i3;
            FeedCloudMeta$StUser feedCloudMeta$StUser;
            PBStringField pBStringField;
            PBStringField pBStringField2;
            Intrinsics.checkNotNullParameter(item, "item");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = j.this.getShareInfo().feed;
            String str3 = null;
            if (feedCloudMeta$StFeed != null && (pBStringField2 = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField2.get();
            } else {
                str = null;
            }
            String str4 = "";
            if (str == null) {
                str = "";
            }
            linkedHashMap.put("xsj_feed_id", str);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = j.this.getShareInfo().feed;
            if (feedCloudMeta$StFeed2 != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed2.poster) != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
                str3 = pBStringField.get();
            }
            if (str3 == null) {
                str3 = "";
            }
            linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str3);
            String str5 = j.this.getShareInfo().shareFrom;
            if (str5 == null) {
                str5 = "";
            }
            linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHARE_FROM, str5);
            if (isSelected) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            linkedHashMap.put("xsj_is_tick", str2);
            linkedHashMap.put("xsj_target_qq", item.f());
            linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.SHARE_CONTENT_TYPE, j.this.u());
            if (j.this.getShareInfo().source == 8) {
                if (j.this.getShareInfo().comment != null) {
                    str4 = j.this.getShareInfo().comment.f398447id.get();
                }
                Intrinsics.checkNotNullExpressionValue(str4, "if (shareInfo.comment !=\u2026.comment.id.get() else \"\"");
                linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, str4);
                if (j.this.getShareInfo().reply != null) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_REPLY, Integer.valueOf(i3));
            }
            j.this.n(QCircleDaTongConstant.ElementId.EM_XSJ_MULTI_SHARE_CHOOSE_BTN, linkedHashMap);
            j.this.N(item, isSelected);
        }

        @Override // j92.b
        public void b(@NotNull Activity activity, @NotNull com.tencent.mobileqq.multishare.action.c item) {
            JSONObject jSONObject;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(item, "item");
            String f16 = item.f();
            String str = j.this.getShareInfo().feed.share.shareCardInfo.get();
            if (str == null) {
                return;
            }
            try {
                jSONObject = new JSONObject(RichTextAtParser.changeAT2PlainText(str)).optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
            } catch (JSONException e16) {
                QLog.e("QFSMultiShareManager", 1, "can not get shareCardInfo -- err:" + e16.getMessage() + ",guildId:" + f16 + ",shareCardInfo:" + str);
                jSONObject = null;
            }
            if (jSONObject == null) {
                QLog.e("QFSMultiShareManager", 1, "metaData is null -- guildId:" + f16 + ",shareCardInfo:" + str);
                return;
            }
            SharePublishGuildFeedParam c16 = c(jSONObject);
            if (c16 != null && c16.isValid()) {
                ((IGuildShareToFeedApi) QRoute.api(IGuildShareToFeedApi.class)).shareToFeedPostAwareForbidden(activity, f16, c16, GuildSharePageSource.UNKNOWN.ordinal(), null);
            }
        }

        @Override // j92.b
        public void d(@NotNull List<? extends ResultRecord> chosenUsers) {
            Intrinsics.checkNotNullParameter(chosenUsers, "chosenUsers");
            j.this.getShareInfo().mMultiShareUsers.clear();
            j.this.getShareInfo().mMultiShareUsers.addAll(chosenUsers);
            ShareActionSheetClickListener shareActionSheetClickListener = j.this.getShareActionSheetClickListener();
            if (shareActionSheetClickListener != null) {
                shareActionSheetClickListener.shareToQQ();
            }
        }

        @Override // j92.b
        public void e(@NotNull List<? extends ResultRecord> sendUsers, @NotNull String leaveMsg) {
            Object firstOrNull;
            String str;
            String str2;
            String str3;
            FeedCloudMeta$StUser feedCloudMeta$StUser;
            PBStringField pBStringField;
            PBStringField pBStringField2;
            String str4;
            String str5;
            int i3;
            Intrinsics.checkNotNullParameter(sendUsers, "sendUsers");
            Intrinsics.checkNotNullParameter(leaveMsg, "leaveMsg");
            j.this.getShareInfo().mDirectShowMsg = leaveMsg;
            j.this.getShareInfo().mMultiShareUsers.clear();
            j.this.getShareInfo().mMultiShareUsers.addAll(sendUsers);
            int i16 = 1;
            j.this.getShareInfo().isFromMultiSharePanel = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_filter_share_success_report_910", true);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) sendUsers);
            ResultRecord resultRecord = (ResultRecord) firstOrNull;
            ShareActionSheetClickListener shareActionSheetClickListener = j.this.getShareActionSheetClickListener();
            String str6 = null;
            String str7 = "";
            if (shareActionSheetClickListener != null) {
                if (resultRecord != null) {
                    str4 = resultRecord.name;
                } else {
                    str4 = null;
                }
                if (str4 == null) {
                    str4 = "";
                }
                if (resultRecord != null) {
                    str5 = resultRecord.uin;
                } else {
                    str5 = null;
                }
                if (str5 == null) {
                    str5 = "";
                }
                if (resultRecord != null) {
                    i3 = resultRecord.uinType;
                } else {
                    i3 = 0;
                }
                shareActionSheetClickListener.shareToSpecifiedFriend(str4, str5, i3);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = j.this.getShareInfo().feed;
            if (feedCloudMeta$StFeed != null && (pBStringField2 = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField2.get();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            linkedHashMap.put("xsj_feed_id", str);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = j.this.getShareInfo().feed;
            if (feedCloudMeta$StFeed2 != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed2.poster) != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
                str6 = pBStringField.get();
            }
            if (str6 == null) {
                str6 = "";
            }
            linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str6);
            linkedHashMap.put("xsj_target_qq", j.this.p(sendUsers));
            String str8 = j.this.getShareInfo().shareFrom;
            if (str8 == null) {
                str8 = "";
            }
            linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHARE_FROM, str8);
            if (!TextUtils.isEmpty(leaveMsg)) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_TEXT, str2);
            linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHARE_NUM, Integer.valueOf(sendUsers.size()));
            if (sendUsers.size() == 1) {
                str3 = "single";
            } else {
                str3 = "multiple";
            }
            linkedHashMap.put("xsj_single_multiple_choice_type", str3);
            linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.SHARE_CONTENT_TYPE, j.this.u());
            if (j.this.getShareInfo().source == 8) {
                if (j.this.getShareInfo().comment != null) {
                    str7 = j.this.getShareInfo().comment.f398447id.get();
                }
                Intrinsics.checkNotNullExpressionValue(str7, "if (shareInfo.comment !=\u2026.comment.id.get() else \"\"");
                linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, str7);
                if (j.this.getShareInfo().reply == null) {
                    i16 = 0;
                }
                linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_REPLY, Integer.valueOf(i16));
            }
            j.this.n(QCircleDaTongConstant.ElementId.EM_XSJ_MULTI_SHARE_SEND_BTN, linkedHashMap);
            j.this.l(sendUsers);
            j.this.C(sendUsers);
            j.this.B(sendUsers);
        }

        @Override // j92.b
        public void f(@NotNull com.tencent.mobileqq.multishare.action.b item) {
            Intrinsics.checkNotNullParameter(item, "item");
            j.this.y(item.getId());
            j.this.x(item.getId());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"yb0/j$c", "Lj92/c;", "Landroid/view/View;", OperateCustomButton.OPERATE_CREATE, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c implements j92.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f449991a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f449992b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f449993c;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"yb0/j$c$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes5.dex */
        public static final class a extends ViewOutlineProvider {
            a() {
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(@NotNull View view, @NotNull Outline outline) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), cx.a(4.0f));
            }
        }

        c(Context context, j jVar, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f449991a = context;
            this.f449992b = jVar;
            this.f449993c = feedCloudMeta$StFeed;
        }

        @Override // j92.c
        @NotNull
        public View create() {
            String str;
            ImageView imageView = new ImageView(this.f449991a);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            imageView.setOutlineProvider(new a());
            imageView.setClipToOutline(true);
            if (this.f449992b.getShareInfo().type == 1) {
                str = this.f449993c.share.author.icon.iconUrl.get();
            } else {
                str = this.f449993c.share.cover.picUrl.get();
            }
            Option targetView = Option.obtain().setUrl(str).setTargetView(imageView);
            targetView.setSupportRecycler(false);
            if (!TextUtils.isEmpty(str)) {
                QCircleFeedPicLoader.g().loadImage(targetView);
            }
            return imageView;
        }
    }

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{3, 9, 10, 171});
        f449980j = listOf;
    }

    public j(@NotNull ShareConfig shareConfig, @NotNull QCircleShareInfo shareInfo) {
        Intrinsics.checkNotNullParameter(shareConfig, "shareConfig");
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        this.shareConfig = shareConfig;
        this.shareInfo = shareInfo;
        this.selectedUserList = new ArrayList();
        QRouteApi api = QRoute.api(IMultiShareApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMultiShareApi::class.java)");
        this.mShareInstance = (IMultiShareApi) api;
    }

    private final void A(String uin) {
        Iterator<com.tencent.mobileqq.multishare.action.c> it = this.shareInfo.mSelectedUserList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "shareInfo.mSelectedUserList.iterator()");
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f(), uin)) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(List<? extends ResultRecord> sendUsers) {
        String str;
        PBStringField pBStringField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.shareInfo.feed;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && !sendUsers.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (ResultRecord resultRecord : sendUsers) {
                if (!TextUtils.isEmpty(resultRecord.uin)) {
                    FeedCloudWrite$ShareItem feedCloudWrite$ShareItem = new FeedCloudWrite$ShareItem();
                    feedCloudWrite$ShareItem.to_uin.set(resultRecord.uin);
                    feedCloudWrite$ShareItem.type.set(ua0.d.g(resultRecord.uinType));
                    arrayList.add(feedCloudWrite$ShareItem);
                }
            }
            ua0.d.D(arrayList, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(final List<? extends ResultRecord> sendUsers) {
        ArrayList arrayList = new ArrayList();
        for (ResultRecord resultRecord : sendUsers) {
            cc.e(resultRecord.uin);
            String str = resultRecord.uin;
            Intrinsics.checkNotNullExpressionValue(str, "user.uin");
            arrayList.add(str);
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: yb0.i
            @Override // java.lang.Runnable
            public final void run() {
                j.D(sendUsers);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(List sendUsers) {
        Object orNull;
        Intrinsics.checkNotNullParameter(sendUsers, "$sendUsers");
        orNull = CollectionsKt___CollectionsKt.getOrNull(sendUsers, 0);
        ResultRecord resultRecord = (ResultRecord) orNull;
        if (resultRecord != null) {
            ua0.d.C(resultRecord.uin, resultRecord.name, resultRecord.uinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(com.tencent.mobileqq.multishare.action.c item, boolean isSelected) {
        if (!com.tencent.biz.qqcircle.immersive.utils.a.e()) {
            return;
        }
        if (isSelected) {
            this.shareInfo.mSelectedUserList.add(item);
        } else {
            A(item.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(List<? extends ResultRecord> sendUsers) {
        int i3;
        for (ResultRecord resultRecord : sendUsers) {
            HostForwardUtils.ForwardInfoEntity forwardInfoEntity = new HostForwardUtils.ForwardInfoEntity();
            forwardInfoEntity.setForwardName(resultRecord.name);
            forwardInfoEntity.setForwardUin(resultRecord.uin);
            forwardInfoEntity.setForwardUinType(resultRecord.uinType);
            QCircleReportBean qCircleReportBean = this.shareInfo.mReportBean;
            int i16 = 0;
            if (qCircleReportBean != null) {
                i3 = qCircleReportBean.getPageId();
            } else {
                i3 = 0;
            }
            QCircleReportBean qCircleReportBean2 = this.shareInfo.mReportBean;
            if (qCircleReportBean2 != null) {
                i16 = qCircleReportBean2.getFromPageId();
            }
            ua0.d.a(i3, i16).o(this.shareInfo.extraTypeInfo, forwardInfoEntity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String emId, Map<String, ? extends Object> extraParams) {
        String str;
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHAREPANEL_SOURCE, Integer.valueOf(this.shareInfo.source));
        map.put("xsj_eid", emId);
        QCircleReportBean qCircleReportBean = this.shareInfo.mReportBean;
        if (qCircleReportBean == null || (str = qCircleReportBean.getDtPageId()) == null) {
            str = "";
        }
        map.put("xsj_custom_pgid", str);
        if (!extraParams.isEmpty()) {
            map.putAll(extraParams);
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", map);
    }

    private final void o() {
        String str;
        String str2;
        String str3;
        int i3;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.shareInfo.feed;
        String str4 = null;
        if (feedCloudMeta$StFeed != null && (pBStringField2 = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        String str5 = "";
        if (str == null) {
            QCircleReportBean qCircleReportBean = this.shareInfo.mReportBean;
            if (qCircleReportBean != null) {
                str = qCircleReportBean.getFeedId();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
        }
        map.put("xsj_feed_id", str);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.shareInfo.feed;
        if (feedCloudMeta$StFeed2 != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed2.poster) != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
            str2 = pBStringField.get();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            QCircleReportBean qCircleReportBean2 = this.shareInfo.mReportBean;
            if (qCircleReportBean2 != null) {
                str4 = qCircleReportBean2.getAuthUin();
            }
            if (str4 == null) {
                str2 = "";
            } else {
                str2 = str4;
            }
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHAREPANEL_SOURCE, Integer.valueOf(this.shareInfo.source));
        map.put("xsj_eid", "em_xsj_sharepanel");
        map.put("eid", "em_xsj_sharepanel");
        QCircleReportBean qCircleReportBean3 = this.shareInfo.mReportBean;
        if (qCircleReportBean3 == null || (str3 = qCircleReportBean3.getDtPageId()) == null) {
            str3 = "";
        }
        map.put("xsj_custom_pgid", str3);
        String str6 = this.shareInfo.shareButtonType;
        if (str6 == null) {
            str6 = "";
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHARE_BUTTON_TYPE, str6);
        String str7 = this.shareInfo.shareFrom;
        if (str7 == null) {
            str7 = "";
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHARE_FROM, str7);
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHAREPANEL_STYLE, "multiple");
        QCircleShareInfo qCircleShareInfo = this.shareInfo;
        if (qCircleShareInfo.source == 8) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = qCircleShareInfo.comment;
            if (feedCloudMeta$StComment != null) {
                str5 = feedCloudMeta$StComment.f398447id.get();
            }
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, str5);
            if (this.shareInfo.reply != null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_REPLY, Integer.valueOf(i3));
        }
        ShareConfig shareConfig = this.shareConfig;
        if (shareConfig.isShowStick) {
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_SET_TOP, 1);
        } else if (shareConfig.isShowUnStick) {
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_SET_TOP, 0);
        }
        if (this.shareConfig.isShowBackgroundMusic) {
            if (this.shareInfo.feed.musicInfo.ID.get() == 0) {
                map.put("xsj_music_id", this.shareInfo.feed.musicInfo.MID.get());
            } else {
                map.put("xsj_music_id", Long.valueOf(this.shareInfo.feed.musicInfo.ID.get()));
            }
            map.put("xsj_music_name", this.shareInfo.feed.musicInfo.musicName.get());
        }
        if (!TextUtils.isEmpty(this.shareInfo.materialType)) {
            map.put("xsj_material_type", this.shareInfo.materialType);
        }
        if (!TextUtils.isEmpty(this.shareInfo.materialId)) {
            map.put("xsj_material_id", this.shareInfo.materialId);
        }
        VideoReport.reportEvent("ev_xsj_abnormal_imp", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p(List<? extends ResultRecord> sendUsers) {
        boolean z16;
        String str = "";
        for (ResultRecord resultRecord : sendUsers) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = str + ",";
            }
            int i3 = resultRecord.uinType;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 10008) {
                        if (i3 == 10014) {
                            str = str + "channel:" + resultRecord.guildId;
                        }
                    } else {
                        str = str + "follow_uin:" + resultRecord.uin;
                    }
                } else {
                    str = str + "groupid:" + resultRecord.uin;
                }
            } else {
                str = str + "uin:" + resultRecord.uin;
            }
        }
        return str;
    }

    private final List<com.tencent.mobileqq.multishare.action.b> q(ShareConfig shareConfig) {
        List<com.tencent.mobileqq.multishare.action.b> list;
        ArrayList arrayList = new ArrayList();
        List<ShareActionSheetBuilder.ActionSheetItem> t16 = t(shareConfig);
        List<ShareActionSheetBuilder.ActionSheetItem> s16 = s(shareConfig);
        for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem : t16) {
            ShareActionLine shareActionLine = ShareActionLine.FIRST;
            int i3 = actionSheetItem.icon;
            String str = actionSheetItem.label;
            Intrinsics.checkNotNullExpressionValue(str, "path.label");
            arrayList.add(new h(shareActionLine, i3, str, actionSheetItem.action));
        }
        for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem2 : s16) {
            ShareActionLine shareActionLine2 = ShareActionLine.SECOND;
            int i16 = actionSheetItem2.icon;
            String str2 = actionSheetItem2.label;
            Intrinsics.checkNotNullExpressionValue(str2, "operation.label");
            arrayList.add(new h(shareActionLine2, i16, str2, actionSheetItem2.action));
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return list;
    }

    private final List<com.tencent.mobileqq.multishare.action.b> r(ShareConfig shareConfig) {
        List<com.tencent.mobileqq.multishare.action.b> list;
        ArrayList arrayList = new ArrayList();
        for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem : s(shareConfig)) {
            ShareActionLine shareActionLine = ShareActionLine.SECOND;
            int i3 = actionSheetItem.icon;
            String str = actionSheetItem.label;
            Intrinsics.checkNotNullExpressionValue(str, "operation.label");
            arrayList.add(new h(shareActionLine, i3, str, actionSheetItem.action));
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return list;
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> s(ShareConfig shareConfig) {
        ArrayList arrayList = new ArrayList();
        if (shareConfig == null) {
            return arrayList;
        }
        if (shareConfig.isShowQrcodeSave) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(210, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowQrcode) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(123, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowCollect) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(6, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowUnCollect) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(84, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowWatchLater) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(236, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowCancelWatchLater) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(237, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowStick) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(186, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowUnStick) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(187, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDelete) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(40, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDataAnalyze) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(209, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowFeedBindQQGroup) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(214, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowSave) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowSetQQProfileCover) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(231, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowQCircleEnterFloatingWindow) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(216, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowCopyShortLink) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(232, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowBackgroundMusic) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(217, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowSetToPublicPermission) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(188, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowSetToPrivatePermission) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(189, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowBarrageOpen) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(142, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowBarrageClose) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(143, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDisLike) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(44, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowHideThisWork) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(141, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowContentPromotion) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(211, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowCopyContent) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(221, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowReport) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(11, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowPushRanComment) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(239, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowFeedback) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(151, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDebug) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(74, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDeletePush) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(140, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDeletePushDisable) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(167, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowDeleteAndEditAlbum) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(191, shareConfig.isForceNightTheme));
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(190, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowCopySchemaLink) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(1, shareConfig.isForceNightTheme));
        }
        return arrayList;
    }

    private final List<ShareActionSheetBuilder.ActionSheetItem> t(ShareConfig shareConfig) {
        ArrayList arrayList = new ArrayList();
        if (shareConfig == null) {
            return arrayList;
        }
        if (shareConfig.isShowShareToFriend) {
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(2, shareConfig.isForceNightTheme);
            if (this.shareInfo.isEnableShareToMutual) {
                build.label = com.tencent.biz.qqcircle.utils.h.a(R.string.c75);
            }
            arrayList.add(build);
        }
        if (shareConfig.isShowShareToChannel && !shareConfig.isShowShareToChannelAtLast) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(171, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowShareToQZone) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowShareToWechat) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowShareToWechatCircle) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10, shareConfig.isForceNightTheme));
        }
        if (shareConfig.isShowShareToChannel && shareConfig.isShowShareToChannelAtLast) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(171, shareConfig.isForceNightTheme));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(int id5) {
        if (id5 != 1) {
            if (id5 != 2) {
                if (id5 != 3) {
                    if (id5 != 39) {
                        if (id5 != 40) {
                            if (id5 != 73) {
                                if (id5 != 74) {
                                    if (id5 != 216) {
                                        if (id5 != 217) {
                                            if (id5 != 231) {
                                                if (id5 != 232) {
                                                    if (id5 != 236) {
                                                        if (id5 != 237) {
                                                            switch (id5) {
                                                                case 6:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener != null) {
                                                                        shareActionSheetClickListener.collect();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 44:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener2 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener2 != null) {
                                                                        shareActionSheetClickListener2.showReportDisLike();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 84:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener3 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener3 != null) {
                                                                        shareActionSheetClickListener3.unCollect();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 86:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener4 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener4 != null) {
                                                                        shareActionSheetClickListener4.hideHim();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 123:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener5 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener5 != null) {
                                                                        shareActionSheetClickListener5.createQrcode();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 151:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener6 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener6 != null) {
                                                                        shareActionSheetClickListener6.feedback();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 162:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener7 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener7 != null) {
                                                                        shareActionSheetClickListener7.jumpQcirclePrivateMessage();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 167:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener8 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener8 != null) {
                                                                        shareActionSheetClickListener8.cancelPushDisable();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 171:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener9 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener9 != null) {
                                                                        shareActionSheetClickListener9.shareToChannel(id5);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 186:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener10 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener10 != null) {
                                                                        shareActionSheetClickListener10.stick();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 187:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener11 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener11 != null) {
                                                                        shareActionSheetClickListener11.unStick();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 188:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener12 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener12 != null) {
                                                                        shareActionSheetClickListener12.changeFeedPermission(true);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 189:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener13 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener13 != null) {
                                                                        shareActionSheetClickListener13.changeFeedPermission(false);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 190:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener14 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener14 != null) {
                                                                        shareActionSheetClickListener14.deleteAlbum();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 191:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener15 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener15 != null) {
                                                                        shareActionSheetClickListener15.editAlbum();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 214:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener16 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener16 != null) {
                                                                        shareActionSheetClickListener16.openFeedBindQQGroupPage();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 221:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener17 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener17 != null) {
                                                                        shareActionSheetClickListener17.copyContent();
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 239:
                                                                    ShareActionSheetClickListener shareActionSheetClickListener18 = this.shareActionSheetClickListener;
                                                                    if (shareActionSheetClickListener18 != null) {
                                                                        shareActionSheetClickListener18.pushRanComment();
                                                                        return;
                                                                    }
                                                                    return;
                                                                default:
                                                                    switch (id5) {
                                                                        case 9:
                                                                            ShareActionSheetClickListener shareActionSheetClickListener19 = this.shareActionSheetClickListener;
                                                                            if (shareActionSheetClickListener19 != null) {
                                                                                shareActionSheetClickListener19.shareToWeChat(id5);
                                                                                return;
                                                                            }
                                                                            return;
                                                                        case 10:
                                                                            ShareActionSheetClickListener shareActionSheetClickListener20 = this.shareActionSheetClickListener;
                                                                            if (shareActionSheetClickListener20 != null) {
                                                                                shareActionSheetClickListener20.shareToWeChatCircle(id5);
                                                                                return;
                                                                            }
                                                                            return;
                                                                        case 11:
                                                                            ShareActionSheetClickListener shareActionSheetClickListener21 = this.shareActionSheetClickListener;
                                                                            if (shareActionSheetClickListener21 != null) {
                                                                                shareActionSheetClickListener21.report();
                                                                                return;
                                                                            }
                                                                            return;
                                                                        default:
                                                                            switch (id5) {
                                                                                case 140:
                                                                                    ShareActionSheetClickListener shareActionSheetClickListener22 = this.shareActionSheetClickListener;
                                                                                    if (shareActionSheetClickListener22 != null) {
                                                                                        shareActionSheetClickListener22.deleteHasPush();
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                case 141:
                                                                                    ShareActionSheetClickListener shareActionSheetClickListener23 = this.shareActionSheetClickListener;
                                                                                    if (shareActionSheetClickListener23 != null) {
                                                                                        shareActionSheetClickListener23.hideThisWork();
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                case 142:
                                                                                    ShareActionSheetClickListener shareActionSheetClickListener24 = this.shareActionSheetClickListener;
                                                                                    if (shareActionSheetClickListener24 != null) {
                                                                                        shareActionSheetClickListener24.switchBarrageOpen();
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                case 143:
                                                                                    ShareActionSheetClickListener shareActionSheetClickListener25 = this.shareActionSheetClickListener;
                                                                                    if (shareActionSheetClickListener25 != null) {
                                                                                        shareActionSheetClickListener25.switchBarrageClose();
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                default:
                                                                                    switch (id5) {
                                                                                        case 209:
                                                                                            ShareActionSheetClickListener shareActionSheetClickListener26 = this.shareActionSheetClickListener;
                                                                                            if (shareActionSheetClickListener26 != null) {
                                                                                                shareActionSheetClickListener26.dataAnalyze();
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        case 210:
                                                                                            ShareActionSheetClickListener shareActionSheetClickListener27 = this.shareActionSheetClickListener;
                                                                                            if (shareActionSheetClickListener27 != null) {
                                                                                                shareActionSheetClickListener27.saveQrcode();
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        case 211:
                                                                                            ShareActionSheetClickListener shareActionSheetClickListener28 = this.shareActionSheetClickListener;
                                                                                            if (shareActionSheetClickListener28 != null) {
                                                                                                shareActionSheetClickListener28.promotion();
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        default:
                                                                                            return;
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                        }
                                                        ShareActionSheetClickListener shareActionSheetClickListener29 = this.shareActionSheetClickListener;
                                                        if (shareActionSheetClickListener29 != null) {
                                                            shareActionSheetClickListener29.cancelWatchLater();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    ShareActionSheetClickListener shareActionSheetClickListener30 = this.shareActionSheetClickListener;
                                                    if (shareActionSheetClickListener30 != null) {
                                                        shareActionSheetClickListener30.watchLater();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                ShareActionSheetClickListener shareActionSheetClickListener31 = this.shareActionSheetClickListener;
                                                if (shareActionSheetClickListener31 != null) {
                                                    shareActionSheetClickListener31.copyShortLink();
                                                    return;
                                                }
                                                return;
                                            }
                                            ShareActionSheetClickListener shareActionSheetClickListener32 = this.shareActionSheetClickListener;
                                            if (shareActionSheetClickListener32 != null) {
                                                shareActionSheetClickListener32.setQQProfileCover();
                                                return;
                                            }
                                            return;
                                        }
                                        ShareActionSheetClickListener shareActionSheetClickListener33 = this.shareActionSheetClickListener;
                                        if (shareActionSheetClickListener33 != null) {
                                            shareActionSheetClickListener33.openMusicAggregationPage();
                                            return;
                                        }
                                        return;
                                    }
                                    ShareActionSheetClickListener shareActionSheetClickListener34 = this.shareActionSheetClickListener;
                                    if (shareActionSheetClickListener34 != null) {
                                        shareActionSheetClickListener34.enterQCircleFloatingWindow();
                                        return;
                                    }
                                    return;
                                }
                                ShareActionSheetClickListener shareActionSheetClickListener35 = this.shareActionSheetClickListener;
                                if (shareActionSheetClickListener35 != null) {
                                    shareActionSheetClickListener35.miniAppDebugOn();
                                    return;
                                }
                                return;
                            }
                        } else {
                            ShareActionSheetClickListener shareActionSheetClickListener36 = this.shareActionSheetClickListener;
                            if (shareActionSheetClickListener36 != null) {
                                shareActionSheetClickListener36.delete();
                                return;
                            }
                            return;
                        }
                    } else {
                        ShareActionSheetClickListener shareActionSheetClickListener37 = this.shareActionSheetClickListener;
                        if (shareActionSheetClickListener37 != null) {
                            shareActionSheetClickListener37.save();
                            return;
                        }
                        return;
                    }
                } else {
                    ShareActionSheetClickListener shareActionSheetClickListener38 = this.shareActionSheetClickListener;
                    if (shareActionSheetClickListener38 != null) {
                        shareActionSheetClickListener38.shareToQZone();
                        return;
                    }
                    return;
                }
            }
            ShareActionSheetClickListener shareActionSheetClickListener39 = this.shareActionSheetClickListener;
            if (shareActionSheetClickListener39 != null) {
                shareActionSheetClickListener39.shareToQQ();
                return;
            }
            return;
        }
        ShareActionSheetClickListener shareActionSheetClickListener40 = this.shareActionSheetClickListener;
        if (shareActionSheetClickListener40 != null) {
            shareActionSheetClickListener40.copyLink();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(int id5) {
        if (com.tencent.biz.qqcircle.immersive.utils.a.d() && f449980j.contains(Integer.valueOf(id5))) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenCloseEvent(bj.g(this.shareInfo.feed), true));
        }
    }

    public final void E(@Nullable j92.d titleCreator) {
        if (titleCreator == null) {
            return;
        }
        this.mShareInstance.setCustomTitleInterface(titleCreator);
    }

    public final void F(@NotNull Intent forwardIntent) {
        Intrinsics.checkNotNullParameter(forwardIntent, "forwardIntent");
        this.mShareInstance.setForwardIntent(forwardIntent);
    }

    public final void G(@Nullable DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public final void H(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    public final void I(@Nullable DialogInterface.OnShowListener onShowListener) {
        this.onShowListener = onShowListener;
    }

    public final void J(@NotNull List<? extends com.tencent.mobileqq.multishare.action.c> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selectedUserList = list;
    }

    public final void K(@Nullable ShareActionSheetClickListener shareActionSheetClickListener) {
        this.shareActionSheetClickListener = shareActionSheetClickListener;
    }

    public final void L(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!QCirclePluginUtil.isFeedOwner(this.shareInfo.feed)) {
            QCircleToast.u(com.tencent.biz.qqcircle.immersive.personal.utils.k.d(), 0, true);
        } else {
            this.mShareInstance.showPanel(context);
            o();
        }
    }

    public final void M(@Nullable ShareConfig shareConfig) {
        List<com.tencent.mobileqq.multishare.action.b> r16 = r(shareConfig);
        if (r16.isEmpty()) {
            QLog.e("QFSMultiShareManager", 1, "[updateOperationsLines] operationActionItems is empty");
        } else {
            this.mShareInstance.updateActionSheet(1, r16);
        }
    }

    public final void j() {
        List<? extends Part> listOf;
        com.tencent.mobileqq.multishare.config.a aVar = new com.tencent.mobileqq.multishare.config.a();
        aVar.D(this.shareInfo.mShareTitle);
        aVar.w(false);
        aVar.q(q(this.shareConfig));
        if (this.shareInfo.isShowPlayRate) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new com.tencent.biz.qqcircle.share.part.b(this.shareInfo));
            aVar.s(listOf);
        }
        aVar.z(this.onShowListener);
        aVar.y(this.onDismissListener);
        aVar.x(this.onCancelListener);
        aVar.t(new b());
        this.mShareInstance.createPanel(aVar);
    }

    public final void k(@NotNull Context context, @NotNull FeedCloudMeta$StFeed feed) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.mShareInstance.setPreviewInterface(new c(context, this, feed));
    }

    public final void m() {
        this.mShareInstance.dismissPanel();
    }

    @NotNull
    public final String u() {
        int i3 = this.shareInfo.type;
        if (i3 != 0) {
            if (i3 != 12 && i3 != 13) {
                return "other";
            }
            return "cmt";
        }
        return "feed";
    }

    @Nullable
    /* renamed from: v, reason: from getter */
    public final ShareActionSheetClickListener getShareActionSheetClickListener() {
        return this.shareActionSheetClickListener;
    }

    @NotNull
    /* renamed from: w, reason: from getter */
    public final QCircleShareInfo getShareInfo() {
        return this.shareInfo;
    }

    public final boolean z() {
        return this.mShareInstance.isShowing();
    }
}

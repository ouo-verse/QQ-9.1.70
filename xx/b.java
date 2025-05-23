package xx;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ds;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.storage.database.DbConst;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;
import xx.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lxx/b;", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static long f448931b;

    /* renamed from: c, reason: collision with root package name */
    private static int f448932c;

    /* renamed from: d, reason: collision with root package name */
    private static long f448933d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private static String f448934e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final HashMap<Integer, Long> f448935f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final HashSet<Integer> f448936g;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b}\u0010~J@\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J0\u0010\u000f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J<\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013H\u0002J6\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\"\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0017H\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0006\u0010\u001f\u001a\u00020\u000bJ\u0010\u0010 \u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\"\u0010#\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0002J\"\u0010$\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0002J\u0010\u0010%\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010&\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010'\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010(\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010)\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\"\u0010*\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0002J\"\u0010+\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0002J\u0010\u0010,\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010-\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010.\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u00100\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u0001J\u001a\u00103\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u0001012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0018\u00107\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u001d2\b\u00106\u001a\u0004\u0018\u000105J\u0016\u0010;\u001a\u00020\u000b2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u000108J\u001c\u0010>\u001a\u0004\u0018\u00010\u00022\b\u0010<\u001a\u0004\u0018\u00010\u00022\b\u0010=\u001a\u0004\u0018\u00010\u0002R\u0014\u0010?\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bA\u0010@R\u0014\u0010B\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0014\u0010C\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bC\u0010@R\u0014\u0010D\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bD\u0010@R\u0014\u0010E\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bE\u0010@R\u0014\u0010F\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bF\u0010@R\u0014\u0010G\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bG\u0010@R\u0014\u0010H\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bH\u0010@R\u0014\u0010I\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bI\u0010@R\u0014\u0010J\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bJ\u0010@R\u0014\u0010K\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bK\u0010@R\u0014\u0010L\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bL\u0010@R\u0014\u0010M\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bM\u0010@R\u0014\u0010N\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bN\u0010@R\u0014\u0010O\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bO\u0010@R\u0014\u0010P\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bP\u0010@R\u0014\u0010Q\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bQ\u0010@R\u0014\u0010R\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bR\u0010@R\u0014\u0010S\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bS\u0010@R\u0014\u0010T\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bT\u0010@R\u0014\u0010U\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bU\u0010@R\u0014\u0010V\u001a\u00020\u001d8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bX\u0010@R\u0014\u0010Y\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bY\u0010@R\u0014\u0010Z\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bZ\u0010@R\u0014\u0010[\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b[\u0010@R\u0014\u0010\\\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\\\u0010@R\u0014\u0010]\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b]\u0010@R\u0014\u0010^\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b^\u0010@R\u0014\u0010_\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b_\u0010@R\u0014\u0010`\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b`\u0010@R\u0014\u0010a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\ba\u0010@R\u0014\u0010b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bb\u0010@R\u0014\u0010c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bc\u0010@R\u0014\u0010d\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bf\u0010eR\u0014\u0010g\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bg\u0010eR\u0014\u0010h\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bh\u0010@R\u0014\u0010i\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bi\u0010@R\u0014\u0010j\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bj\u0010@R\u0014\u0010k\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bk\u0010@R\u0014\u0010l\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bl\u0010@R$\u0010o\u001a\u0012\u0012\u0004\u0012\u00020\b0mj\b\u0012\u0004\u0012\u00020\b`n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010q\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010eR\u0016\u0010s\u001a\u00020r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010u\u001a\u00020r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010tR\u0016\u0010v\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010eR\u0016\u0010w\u001a\u00020r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010tR\u0016\u0010x\u001a\u00020r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010@R0\u0010z\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020r0\u0016j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020r`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010|\u001a\u00020r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010t\u00a8\u0006\u007f"}, d2 = {"Lxx/b$a;", "", "", "toUin", "oacMessage", "", "messageContent", "msgId", "", QQBrowserActivity.KEY_MSG_TYPE, "redNum", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "location", "url", "g", "j", "action", "subActionType", "", "extra", HippyTKDListViewAdapter.X, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "paramsMap", "b", "d", "oacMessageExtend", "f", "", "D", "i", h.F, "menuId", "menuContent", "l", "k", "o", "p", "v", "w", ReportConstant.COSTREPORT_PREFIX, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "t", "u", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;", DTConstants.TAG.ELEMENT, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "showMsgContent", "Landroid/content/Intent;", "intent", "B", "", "Lcom/tencent/mobileqq/data/MessageRecord;", "list", BdhLogUtil.LogTag.Tag_Conn, AppConstants.Key.COLUMN_EXT_STR, "key", "e", "ACTION_AIO", "Ljava/lang/String;", "ACTION_ARTICLE", "ACTION_LOCK_SCREEN_PUSH", "ACTION_MENU", "ACTION_MSG", "ACTION_MSG_LIST", "ACTION_PROFILE", "ACTION_PROFILE_DOTS", "ACTION_PROFILE_ENTER_AIO", "ACTION_PROFILE_FOLLOW", "ACTION_PROFILE_MENU", "ACTION_PROFILE_UNFOLLOW", "ACTION_SETTING_CLOSE", "ACTION_SETTING_OPEN", "ACTION_SHOP_LIST", "ACTION_SUBSCRIBE_LIST", "ACTION_SUB_PROFILE", "ACTION_TO_UIN", "ACTION_UIN", "DATONG_KEY", "DEBUG_KEY", "EVENT_ID", "IS_DEBUG", "Z", "KEY", "KEY_ACTION_TYPE", "KEY_DURATION", "KEY_LOCATION_ID", "KEY_MENU_CONTENT", "KEY_MENU_ID", "KEY_MSG_CONTENT", "KEY_MSG_ID", "KEY_MSG_TYPE", "KEY_OAC_TRIGGLE", "KEY_RED_NUM", "KEY_SUBACTION_TYPE", "RANDOM_END", "I", "RANDOM_NUMBER", "RANDOM_START", "SUB_ACTION_ACCEPT", "SUB_ACTION_CLICK", "SUB_ACTION_EXPO", "SUB_ACTION_STAY", "TAG", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mAioExpoRecordSet", "Ljava/util/HashSet;", "mAioListExpoInitTimeLimit", "", "mAioResidentStartTime", "J", "mArticleResidentStartTime", "mExpoTimeLimit", "mLastPushClickReportTime", "mLastRefreshAioExpoRecordTime", "mOacMessageOnListClick", "mProfileMenuExpoRecordMap", "Ljava/util/HashMap;", "mReporterInitTime", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xx.b$a, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean D() {
            if (ds.d(0, 100000) >= 10) {
                return false;
            }
            return true;
        }

        private final void b(final String toUin, final HashMap<String, String> paramsMap) {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: xx.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.Companion.c(paramsMap, toUin);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(HashMap paramsMap, String str) {
            Intrinsics.checkNotNullParameter(paramsMap, "$paramsMap");
            try {
                String uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                paramsMap.put("uin", uin);
                paramsMap.put("A8", uin);
                if (str != null) {
                    paramsMap.put("target_qq", str);
                }
                QLog.d("OfficialAccountReporter", 2, "doReport " + paramsMap);
                String str2 = "PublicAccountReport";
                if (paramsMap.containsKey("code")) {
                    str2 = String.valueOf(paramsMap.get("code"));
                }
                String str3 = str2;
                if (b.INSTANCE.D()) {
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("00000KCQ7Y3ITP3Z", uin, str3, true, -1L, -1L, (HashMap<String, String>) paramsMap, "");
                }
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        private final int d() {
            if (b.f448932c > 0) {
                return b.f448932c;
            }
            b.f448932c = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_OFFICIAL_ACCOUNT, QzoneConfig.SECONDARY_KEY_OFFICIAL_ACCOUNT_REPORT_TIME_LIMIT, 3000);
            return b.f448932c;
        }

        private final String f(String oacMessageExtend) {
            try {
                if (!TextUtils.isEmpty(oacMessageExtend)) {
                    String optString = new JSONObject(oacMessageExtend).optString("oac_triggle");
                    Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"oac_triggle\")");
                    return optString;
                }
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, "getOacTriggle error: " + oacMessageExtend, e16);
            }
            return "";
        }

        private final void g(String location, String url, String toUin, String oacMessage) {
            HashMap hashMap = new HashMap();
            if (location != null) {
                hashMap.put("location_id", location);
            }
            if (url != null) {
                hashMap.put("msg_content", url);
            }
            if (oacMessage != null) {
                hashMap.put("tianshu_transfer", f(oacMessage));
            }
            x("gzh_aio", "click", toUin, hashMap);
        }

        private final void j(String toUin) {
            y(this, "lockscreen_push", "expo", toUin, null, 8, null);
        }

        private final void m(String toUin, String oacMessage, CharSequence messageContent, String msgId, int msgType, int redNum) {
            HashMap hashMap = new HashMap();
            if (oacMessage != null) {
                String f16 = f(oacMessage);
                hashMap.put("tianshu_transfer", f16);
                b.f448934e = f16;
            }
            if (messageContent != null) {
                hashMap.put("msg_content", messageContent.toString());
            }
            if (msgId != null) {
                hashMap.put("msg_id", msgId);
            }
            if (msgType != 0) {
                hashMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, String.valueOf(msgType));
            }
            hashMap.put("reddot_num", String.valueOf(redNum));
            x("msg_list", "click", toUin, hashMap);
        }

        private final void x(String action, String subActionType, String toUin, Map<String, String> extra) {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                if (action != null) {
                    hashMap.put(DbConst.OBJECT_ID, action);
                }
                if (subActionType != null) {
                    hashMap.put("code", subActionType);
                }
                for (Map.Entry<String, String> entry : extra.entrySet()) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
                b(toUin, hashMap);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ void y(Companion companion, String str, String str2, String str3, Map map, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                map = new HashMap();
            }
            companion.x(str, str2, str3, map);
        }

        public final void A(@Nullable AbsStructMsgElement element, @Nullable String oacMessage) {
            if (element != null) {
                try {
                    g(element.K0, element.f290327h, element.M0, oacMessage);
                } catch (Exception e16) {
                    QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
                }
            }
        }

        public final void B(boolean showMsgContent, @Nullable Intent intent) {
            if (showMsgContent && intent != null) {
                try {
                    int intExtra = intent.getIntExtra("uintype", -1);
                    String stringExtra = intent.getStringExtra("uin");
                    if (intExtra == 1008 || intExtra == 7120 || intExtra == 7230) {
                        j(stringExtra);
                    }
                } catch (Exception e16) {
                    QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
                }
            }
        }

        public final void C(@Nullable List<? extends MessageRecord> list) {
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        for (MessageRecord messageRecord : list) {
                            int i3 = messageRecord.istroop;
                            if (i3 == 1008 || i3 == 7230 || i3 == 7120) {
                                String str = messageRecord.frienduin;
                                String msgId = messageRecord.getExtInfoFromExtStr(AppConstants.Key.KEY_PUBLIC_ACCOUNT_MSGID);
                                String optString = new JSONObject(messageRecord.extStr).optString(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND);
                                HashMap hashMap = new HashMap();
                                Intrinsics.checkNotNullExpressionValue(msgId, "msgId");
                                hashMap.put("msg_id", msgId);
                                hashMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, String.valueOf(messageRecord.msgtype));
                                hashMap.put("tianshu_transfer", f(optString));
                                x("gzh_msg", "accept", str, hashMap);
                            }
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
                }
            }
        }

        @Nullable
        public final String e(@Nullable String extStr, @Nullable String key) {
            if (TextUtils.isEmpty(extStr)) {
                return "";
            }
            try {
                JSONObject jSONObject = new JSONObject(extStr);
                if (!jSONObject.has(key)) {
                    return "";
                }
                return jSONObject.getString(key);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
                return "";
            }
        }

        public final void h(@Nullable String toUin) {
            try {
                if (b.f448931b > 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(SegmentKeeper.KEY_DURATION, String.valueOf(SystemClock.elapsedRealtime() - b.f448931b));
                    x("gzh_article", QCircleDaTongConstant.ElementParamValue.STAY, toUin, hashMap);
                }
                b.f448931b = 0L;
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        public final void i() {
            b.f448931b = SystemClock.elapsedRealtime();
        }

        public final void k(@Nullable String toUin, int menuId, @Nullable String menuContent) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("menu_id", String.valueOf(menuId));
                if (menuContent != null) {
                    hashMap.put("menu_content", menuContent);
                }
                x("gzh_menu", "click", toUin, hashMap);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        public final void l(@Nullable String toUin, int menuId, @Nullable String menuContent) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("menu_id", String.valueOf(menuId));
                if (menuContent != null) {
                    hashMap.put("menu_content", menuContent);
                }
                x("gzh_menu", "expo", toUin, hashMap);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        public final void n(@Nullable String toUin) {
            try {
                y(this, "gzh_profile_aio_entrance", "click", toUin, null, 8, null);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        public final void o(@Nullable String toUin) {
            try {
                y(this, "gzh_profile", "expo", toUin, null, 8, null);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        public final void p(@Nullable String toUin) {
            try {
                y(this, "gzh_profile_follow", "click", toUin, null, 8, null);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        public final void q(@Nullable String toUin, int menuId, @Nullable String menuContent) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("menu_id", String.valueOf(menuId));
                if (menuContent != null) {
                    hashMap.put("menu_content", menuContent);
                }
                x("gzh_profile_menu", "click", toUin, hashMap);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        public final void r(@Nullable String toUin, int menuId, @Nullable String menuContent) {
            try {
                int hashCode = (toUin + menuId + menuContent).hashCode();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Long l3 = (Long) b.f448935f.get(Integer.valueOf(hashCode));
                if (l3 != null && elapsedRealtime <= l3.longValue() + d()) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("menu_id", String.valueOf(menuId));
                if (menuContent != null) {
                    hashMap.put("menu_content", menuContent);
                }
                x("gzh_profile_menu", "expo", toUin, hashMap);
                b.f448935f.put(Integer.valueOf(hashCode), Long.valueOf(SystemClock.elapsedRealtime()));
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        public final void s(@Nullable String toUin) {
            try {
                y(this, "gzh_profile_dots", "click", toUin, null, 8, null);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        public final void t(@Nullable String toUin) {
            try {
                y(this, "gzh_msg_setting_open", "click", toUin, null, 8, null);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        public final void u(@Nullable String toUin) {
            try {
                y(this, "gzh_msg_setting_close", "click", toUin, null, 8, null);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        public final void v(@Nullable String toUin) {
            try {
                y(this, "gzh_profile_unfollow", "click", toUin, null, 8, null);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        public final void w(@Nullable String toUin) {
            try {
                y(this, "gzh_sub_profile", "click", toUin, null, 8, null);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        public final void z(@Nullable Object data) {
            Message S;
            try {
                if (!(data instanceof RecentItemPublicAccountChatMsgData) || (S = ((RecentItemPublicAccountChatMsgData) data).S()) == null) {
                    return;
                }
                m(((RecentItemPublicAccountChatMsgData) data).getRecentUserUin(), ((RecentItemPublicAccountChatMsgData) data).mReportKeyBytesOacMsgxtend, ((RecentItemPublicAccountChatMsgData) data).mLastMsg, e(S.extStr, AppConstants.Key.KEY_PUBLIC_ACCOUNT_MSGID), S.msgtype, ((RecentItemPublicAccountChatMsgData) data).mUnreadNum);
            } catch (Exception e16) {
                QLog.e("OfficialAccountReporter", 2, e16, new Object[0]);
            }
        }

        Companion() {
        }
    }

    static {
        QLog.e("OfficialAccountReporter", 2, "OfficialAccountReporter.init: false");
        UserAction.registerTunnel(new TunnelInfo("00000KCQ7Y3ITP3Z"));
        f448933d = SystemClock.elapsedRealtime();
        f448935f = new HashMap<>();
        f448936g = new HashSet<>();
    }
}

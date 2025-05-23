package r05;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.h;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hitrate.d;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.api.IPreviewTextApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.util.BinderWarpper;
import cooperation.peak.PeakConstants;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static d f430452a = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f430454c = "extra.MIXED_MSG_FIRST_INDEX";

    /* renamed from: b, reason: collision with root package name */
    public static String f430453b = RichMediaBrowserConstants.EXTRA_IS_REPLY_SRC_MSG_EXIST;

    /* renamed from: d, reason: collision with root package name */
    public static final SparseBooleanArray f430455d = new SparseBooleanArray();

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f430456e = {5, 7, 9};

    static {
        boolean z16;
        for (int i3 = 0; i3 < 10; i3++) {
            int[] iArr = f430456e;
            int length = iArr.length;
            int i16 = 0;
            while (true) {
                if (i16 < length) {
                    z16 = true;
                    if (i3 == iArr[i16] - 1) {
                        f430455d.put(i3, true);
                        break;
                    }
                    i16++;
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                f430455d.put(i3, false);
            }
        }
    }

    public static void a(Context context, Bundle bundle, h hVar, AIORichMediaData aIORichMediaData, int i3, int i16) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        boolean z16 = bundle.getBoolean("extra.ENTER_NEW_GALLERY");
        Intent intent = new Intent(context, (Class<?>) AIOGalleryActivity.class);
        boolean z17 = context instanceof PublicFragmentActivity;
        if (!bundle.getBoolean("extra.EXTRA_NOT_CLEAR_TOP", false) && i16 != 3 && i16 != 2) {
            intent.addFlags(603979776);
        } else {
            intent.addFlags(536870912);
        }
        bundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(hVar.asBinder()));
        if (z16) {
            bundle.putParcelable(RichMediaBrowserConstants.INTERNAL_EXTRA_CURRENT_IMAGE, com.tencent.mobileqq.richmediabrowser.utils.d.g(aIORichMediaData));
        } else {
            bundle.putParcelable(RichMediaBrowserConstants.INTERNAL_EXTRA_CURRENT_IMAGE, aIORichMediaData);
        }
        bundle.putInt(RichMediaBrowserConstants.INTERNAL_EXTRA_ENTRANCE, i16);
        if (aIORichMediaData != null) {
            bundle.putBoolean(RichMediaBrowserConstants.EXTRA_IS_MIXED_MSG, aIORichMediaData.D);
        }
        boolean z18 = context instanceof SplashActivity;
        if (!z18 && !(context instanceof ChatActivity)) {
            if (z17) {
                ((PublicFragmentActivity) context).G2();
            } else if (context instanceof ChatHistoryFileActivity) {
                bundle.putBoolean(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT, true);
            } else if (((IPreviewTextApi) QRoute.api(IPreviewTextApi.class)).isPreviewTextAct(context)) {
                bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity) context).getClass().getName());
                bundle.putBoolean(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT, true);
            }
        } else {
            if (context instanceof MultiForwardActivity) {
                AppInterface appInterface = ((BaseActivity) context).getAppInterface();
                if (appInterface instanceof QQAppInterface) {
                    bundle.putBoolean(RichMediaBrowserConstants.EXTRA_FROM_AIO, true);
                    bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
                    String string = bundle.getString("extra.GROUP_UIN");
                    if (string != null && ((QQAppInterface) appInterface).getTroopMask(string) == GroupMsgMask.ASSISTANT) {
                        bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
                    }
                    if (aIORichMediaData != null && aIORichMediaData.C) {
                        bundle.putLong(PeakConstants.KEY_MULTI_FORWARD_SEQ, ((MultiForwardActivity) context).getIntent().getLongExtra("origin_merge_structing_msg_uniseq", 0L));
                    }
                }
            } else {
                bundle.putBoolean(RichMediaBrowserConstants.EXTRA_FROM_AIO, true);
                if (z18) {
                    bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
                } else {
                    bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity) context).getClass().getName());
                }
                b(context, bundle, (Activity) context);
            }
            bundle.putBoolean(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT, true);
        }
        if (bundle.getInt("uintype", -1) == -1 && aIORichMediaData != null) {
            bundle.putInt("uintype", aIORichMediaData.f179633m);
        }
        intent.putExtras(bundle);
        String stackTraceString = QLog.getStackTraceString(new RuntimeException());
        QLog.i("PEAK", 1, "open gallery, intent=" + intent + ", extra=" + bundle + ", entrace=" + i16 + ", stacks=" + stackTraceString);
        d(stackTraceString);
        if (i3 < 0) {
            context.startActivity(intent);
        } else if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i3);
        }
        d dVar = f430452a;
        if (dVar != null) {
            dVar.d();
        }
    }

    private static void b(Context context, Bundle bundle, Activity activity) {
        if (!(context instanceof QBaseActivity)) {
            QLog.w("PEAK", 1, "fillGalleryVideoPreviewEditParams error, context is not instance of QBaseActivity!");
            return;
        }
        AppRuntime appRuntime = ((QBaseActivity) context).getAppRuntime();
        if (appRuntime == null) {
            QLog.e("PEAK", 1, "fillGalleryVideoPreviewEditParams error, appRuntime is null!");
            return;
        }
        if (bundle == null) {
            QLog.e("PEAK", 1, "fillGalleryVideoPreviewEditParams error, extras is null!");
            return;
        }
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("aio_video_preview_enable_edit");
        if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "fillGalleryVideoPreviewEditParams isVideoPreviewEnableEdit = ", Boolean.valueOf(isFeatureSwitchEnable));
        }
        if (!isFeatureSwitchEnable) {
            return;
        }
        bundle.putBoolean(PeakConstants.VIDEO_EDIT_ENABLED, true);
        bundle.putBoolean(PeakConstants.VIDEO_EDIT_AND_THEN_PREVIEW, true);
        bundle.putInt(PeakConstants.KEY_PIC_TO_EDIT_FROM, 4);
        bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", activity.getPackageName());
        bundle.putString(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, activity.getPackageName());
        bundle.putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
    }

    public static boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("old_rich_media_view_witch", false);
    }

    private static void d(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("key_stack", str);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getCurrentUin();
        } else {
            str2 = "0";
        }
        QQBeaconReport.report(str2, "check_old_richmedia_browser", hashMap);
    }
}

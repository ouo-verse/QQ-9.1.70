package u5;

import FileUpload.MarkUinInfoBeforeUpload;
import NS_MOBILE_OPERATION.PicInfo;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.ui.activity.QZonePublishMoodActivity;
import com.qzone.publish.ui.model.ShuoshuoContent;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@Deprecated
/* loaded from: classes36.dex */
public class b {
    private static void A(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("shuoshuo_sync_bits" + str + "_" + j3);
    }

    public static void A0(String str, long j3) {
        c.Q(str, j3);
    }

    public static boolean B(String str) {
        return c.a(str);
    }

    public static List<Friend> C(String str, long j3) {
        int H = H("key_at_friends_size" + str, 0, j3);
        if (H <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < H; i3++) {
            Friend friend = new Friend();
            friend.mUin = K("key_at_friends_uin" + str + i3, 0L, j3);
            friend.mName = j0("key_at_friends_name" + str + i3, "", j3);
            arrayList.add(friend);
        }
        return arrayList;
    }

    public static void C0(String str, String str2, long j3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        v0("shuoshuo_egg_photo_hit_record" + str + "_" + j3, str2);
    }

    public static boolean D(String str, boolean z16) {
        return c.f(str, z16);
    }

    public static void D0(boolean z16, int i3, long j3, long j16) {
        SharedPreferences.Editor c16 = c.c(j16 + "_far");
        c16.putBoolean("key_feed_action_report_is_report_needed", z16);
        c16.putInt("key_feed_action_report_report_network_tag", i3);
        c16.putLong("key_feed_action_report_time_tag", j3);
        c16.commit();
    }

    public static boolean E(String str, boolean z16, long j3) {
        return c.g(str, z16, j3);
    }

    public static void E0(long j3, long j16) {
        t0(j16 + "_far", "key_feed_action_report_time_tag", j3);
    }

    public static String F(String str, long j3) {
        return h0("shuoshuo_egg_photo_hit_record" + str + "_" + j3, "");
    }

    public static void F0(LbsDataV2.GeoInfo geoInfo) {
        SharedPreferences.Editor b16 = c.b();
        b16.putString("last.geo.address", geoInfo.address);
        b16.putString("last.geo.defName", geoInfo.strDefaultName);
        b16.putString("last.geo.country", geoInfo.strCountry);
        b16.putString("last.geo.province", geoInfo.strProvince);
        b16.putString("last.geo.city", geoInfo.strCity);
        b16.putInt("last.geo.lat", geoInfo.gpsInfo.lat);
        b16.putInt("last.geo.lon", geoInfo.gpsInfo.lon);
        b16.putInt("last.geo.acc", geoInfo.gpsInfo.accuracy);
        b16.putInt("last.geo.type", geoInfo.gpsInfo.gpsType);
        b16.commit();
    }

    public static int G(String str, int i3) {
        return c.h(str, i3);
    }

    public static void G0(LbsDataV2.GpsInfo gpsInfo, long j3) {
        SharedPreferences.Editor b16 = c.b();
        b16.putInt("QzLastGpsLat", gpsInfo.lat);
        b16.putInt("QzLastGpsLon", gpsInfo.lon);
        b16.putInt("QzLastGpsType", gpsInfo.gpsType);
        b16.putLong("QzLastGpsTs", j3);
        b16.commit();
    }

    public static int H(String str, int i3, long j3) {
        return c.j(str, i3, j3);
    }

    public static long I(String str, long j3) {
        return c.k(str, j3);
    }

    public static long J(String str, String str2, long j3) {
        return c.l(str, str2, j3);
    }

    public static long K(String str, long j3, long j16) {
        return c.m(str, j3, j16);
    }

    public static int L(String str, int i3, long j3) {
        return H("key_photo_upload_quality_" + str, i3, j3);
    }

    @Deprecated
    public static void L0(String str, int i3, long j3) {
        r0("key_photo_upload_quality_" + str, i3, j3);
    }

    public static SharedPreferences M(String str) {
        return c.p(str);
    }

    private static void M0(SharedPreferences.Editor editor, String str, int i3, long j3) {
        editor.putInt(PeakConstants.KEY_SHOW_TYPE + str + "_" + j3, i3);
    }

    public static SharedPreferences N(long j3) {
        return c.q(j3);
    }

    public static SharedPreferences.Editor O() {
        return c.b();
    }

    private static void O0(SharedPreferences.Editor editor, String str, String str2, long j3) {
        editor.putString("key_shuoshuo_draft" + str + "_" + j3, str2);
    }

    public static HashMap<String, ShuoshuoVideoInfo> P(String str, long j3) {
        String h06 = h0("key_shuoshuo_record_media" + str + "_" + j3, "");
        HashMap<String, ShuoshuoVideoInfo> hashMap = null;
        if (TextUtils.isEmpty(h06)) {
            return null;
        }
        byte[] decode = Base64.decode(h06, 0);
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            hashMap = ParcelableWrapper.readHashMap(obtain, ParcelableWrapper.class.getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            return hashMap;
        } catch (Exception e16) {
            QZLog.w(e16);
            return hashMap;
        }
    }

    @Deprecated
    public static void P0(String str, String str2, long j3) {
        v0("key_shuoshuo_draft" + str + "_" + j3, str2);
    }

    public static HashMap<String, ShuoshuoVideoInfo> Q(String str, long j3) {
        String h06 = h0("key_shuoshuo_select_list_media" + str + "_" + j3, "");
        HashMap<String, ShuoshuoVideoInfo> hashMap = null;
        if (TextUtils.isEmpty(h06)) {
            return null;
        }
        byte[] decode = Base64.decode(h06, 0);
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            hashMap = ParcelableWrapper.readHashMap(obtain, ParcelableWrapper.class.getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            return hashMap;
        } catch (Exception e16) {
            QZLog.w(e16);
            return hashMap;
        }
    }

    private static void Q0(SharedPreferences.Editor editor, String str, long j3, String str2, String str3, int i3, String str4, String str5, String str6) {
        editor.putString("shuoshuo_event_tag_title" + str + "_" + j3, str2);
        editor.putString("shuoshuo_event_tag_desc" + str + "_" + j3, str3);
        editor.putInt("shuoshuo_event_tag_desc_truncate_num" + str + "_" + j3, i3);
        editor.putString("shuoshuo_event_tag_protocol" + str + "_" + j3, str4);
        editor.putString("shuoshuo_event_tag_pic_url" + str + "_" + j3, str5);
        editor.putString("shuoshuo_event_tag_id" + str + "_" + j3, str6);
    }

    public static int R(String str, long j3) {
        return G(PeakConstants.KEY_SHOW_TYPE + str + "_" + j3, 0);
    }

    private static void R0(SharedPreferences.Editor editor, String str, int i3, long j3) {
        editor.putInt("key_shuoshuo_right" + str + "_" + j3, i3);
    }

    public static String S(String str, long j3) {
        return h0("key_shuoshuo_draft" + str + "_" + j3, "");
    }

    public static Map<String, LocalMediaInfo> T(String str, long j3) {
        String h06 = h0("key_shuoshuo_selected_media" + str + "_" + j3, "");
        HashMap hashMap = null;
        if (TextUtils.isEmpty(h06)) {
            return null;
        }
        byte[] decode = Base64.decode(h06, 0);
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            hashMap = ParcelableWrapper.readHashMap(obtain, ParcelableWrapper.class.getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            return hashMap;
        } catch (Throwable th5) {
            QZLog.w(th5);
            return hashMap;
        }
    }

    private static void T0(SharedPreferences.Editor editor, String str, int i3, long j3) {
        editor.putInt("shuoshuo_uistate" + str + "_" + j3, i3);
    }

    public static int U(String str, long j3) {
        return G("key_shuoshuo_right" + str + "_" + j3, 1);
    }

    private static void U0(SharedPreferences.Editor editor, String str, long j3, long j16) {
        editor.putLong("key_shuoshuo_timer" + str + "_" + j16, j3);
    }

    public static ArrayList<String> V(String str, long j3) {
        int H = H("key_shuoshuo_right_uin_list_size" + str, 0, j3);
        if (H <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < H; i3++) {
            String j06 = j0("key_shuoshuo_right_uin_list" + str + i3, "", j3);
            if (!TextUtils.isEmpty(j06)) {
                arrayList.add(j06);
            }
        }
        return arrayList;
    }

    private static void V0(SharedPreferences.Editor editor, String str, String str2, long j3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        editor.putString("key_shuoshuo_shootinfo_dianping_id" + str + "_" + j3, str2);
    }

    public static List<String> W(String str, long j3) {
        String[] split;
        String h06 = h0("key_shuoshuo_selected_images" + str + "_" + j3, "");
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(h06) && (split = h06.split("\\|")) != null) {
            for (String str2 : split) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    private static void W0(SharedPreferences.Editor editor, String str, String str2, long j3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        editor.putString("key_shuoshuo_shootinf_lbs" + str + "_" + j3, str2);
    }

    public static HashMap<String, PicInfo> X(String str, long j3) {
        String h06 = h0("key_shuoshuo_selected_qzone_photo" + str + "_" + j3, "");
        HashMap<String, PicInfo> hashMap = null;
        if (TextUtils.isEmpty(h06)) {
            return null;
        }
        byte[] decode = Base64.decode(h06, 0);
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            hashMap = ParcelableWrapper.readHashMap(obtain, ParcelableWrapper.class.getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            return hashMap;
        } catch (Exception e16) {
            QZLog.w(e16);
            return hashMap;
        }
    }

    private static void X0(SharedPreferences.Editor editor, String str, String str2, long j3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        editor.putString("key_shuoshuo_shootinfo_poi_id" + str + "_" + j3, str2);
    }

    public static ShuoshuoVideoInfo Y(String str, long j3) {
        String h06 = h0("key_shuoshuo_selected_video" + str + "_" + j3, "");
        ShuoshuoVideoInfo shuoshuoVideoInfo = null;
        if (TextUtils.isEmpty(h06)) {
            return null;
        }
        byte[] decode = Base64.decode(h06, 0);
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            ShuoshuoVideoInfo shuoshuoVideoInfo2 = (ShuoshuoVideoInfo) ParcelableWrapper.createDataFromParcel(obtain);
            try {
                OaidMonitor.parcelRecycle(obtain);
                return shuoshuoVideoInfo2;
            } catch (Exception e16) {
                e = e16;
                shuoshuoVideoInfo = shuoshuoVideoInfo2;
                QZLog.w(e);
                return shuoshuoVideoInfo;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private static void Y0(SharedPreferences.Editor editor, String str, String str2, long j3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        editor.putString("key_shuoshuo_shootinfo_time_and_weather" + str + "_" + j3, str2);
    }

    public static long Z(String str, long j3) {
        return I("key_shuoshuo_timer" + str + "_" + j3, 0L);
    }

    private static void a(SharedPreferences.Editor editor, String str, long j3) {
        int H = H("key_at_friends_size" + str, 0, j3);
        if (H > 0) {
            for (int i3 = 0; i3 < H; i3++) {
                editor.remove("key_at_friends_uin" + str + i3);
                editor.remove("key_at_friends_name" + str + i3);
            }
        }
        editor.remove("key_at_friends_size" + str);
    }

    public static String a0(String str, long j3) {
        return h0("key_shuoshuo_title_draft" + str + "_" + j3, "");
    }

    public static void b(String str, long j3) {
        z0("shuoshuo_egg_photo_hit_record" + str + "_" + j3);
    }

    public static PublishEventTag b0(String str, long j3) {
        PublishEventTag publishEventTag = new PublishEventTag();
        publishEventTag.title = N(j3).getString("shuoshuo_event_tag_title" + str + "_" + j3, null);
        publishEventTag.desc = N(j3).getString("shuoshuo_event_tag_desc" + str + "_" + j3, null);
        publishEventTag.descTruncateNum = N(j3).getInt("shuoshuo_event_tag_desc_truncate_num" + str + "_" + j3, 0);
        publishEventTag.f45887protocol = N(j3).getString("shuoshuo_event_tag_protocol" + str + "_" + j3, null);
        publishEventTag.picUrl = N(j3).getString("shuoshuo_event_tag_pic_url" + str + "_" + j3, null);
        publishEventTag.f45886id = N(j3).getString("shuoshuo_event_tag_id" + str + "_" + j3, null);
        if (TextUtils.isEmpty(publishEventTag.title) || TextUtils.isEmpty(publishEventTag.f45887protocol)) {
            return null;
        }
        return publishEventTag;
    }

    private static void c(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("key_shuoshuo_markhascheckfacesmap" + str + "_" + j3);
    }

    public static String c0(String str, long j3) {
        return h0("key_shuoshuo_shootinfo_dianping_id" + str + "_" + j3, "");
    }

    private static void d(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("key_shuoshuo_marksfacedatamap" + str + "_" + j3);
    }

    public static String d0(String str, long j3, String str2) {
        return h0("key_shuoshuo_shootinf_lbs" + str + "_" + j3, str2);
    }

    private static void e(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("key_shuoshuo_upload_map" + str + "_" + j3);
    }

    public static String e0(String str, long j3) {
        return h0("key_shuoshuo_shootinfo_poi_id" + str + "_" + j3, "");
    }

    public static void f(long j3, String str) {
        SharedPreferences.Editor b16 = c.b();
        SharedPreferences.Editor d16 = c.d(j3);
        A(b16, str, j3);
        v(b16, str, j3);
        k(b16, str, j3);
        p(b16, str, j3);
        a(d16, str, j3);
        s(d16, str, j3);
        r(b16, str, j3);
        t(b16, str, j3);
        l(d16, str, j3);
        g(d16, str, j3);
        h(d16, str, j3);
        m(d16, str, j3);
        n(b16, str, j3);
        o(d16, str, j3);
        x(b16, str, j3);
        z(b16, str, j3);
        y(b16, str, j3);
        w(b16, str, j3);
        e(b16, str, j3);
        d(b16, str, j3);
        c(b16, str, j3);
        i(b16, str, j3);
        b16.commit();
        d16.commit();
    }

    public static String f0(String str, long j3) {
        return h0("key_shuoshuo_shootinfo_time_and_weather" + str + "_" + j3, "");
    }

    public static void f1(int i3, long j3) {
        q0("mood_status_" + j3, i3);
    }

    private static void g(SharedPreferences.Editor editor, String str, long j3) {
        z0("key_shuoshuo_record_media" + str + "_" + j3);
    }

    public static int g0(String str, int i3, long j3) {
        return N(j3).getInt("shuoshuo_uistate" + str + "_" + j3, i3);
    }

    private static void h(SharedPreferences.Editor editor, String str, long j3) {
        z0("key_shuoshuo_select_list_media" + str + "_" + j3);
    }

    public static String h0(String str, String str2) {
        return c.s(str, str2);
    }

    private static void i(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove(PeakConstants.KEY_SHOW_TYPE + str + "_" + j3);
    }

    public static String i0(String str, String str2, String str3) {
        return c.t(str, str2, str3);
    }

    public static void j(long j3) {
        SharedPreferences.Editor b16 = c.b();
        SharedPreferences.Editor d16 = c.d(j3);
        b16.putInt(QZonePublishMoodActivity.Vo("shuoshuo_sync_bits", j3), 0);
        k(b16, "_shuoshuo", j3);
        p(b16, "_shuoshuo", j3);
        a(d16, "_shuoshuo", j3);
        s(d16, "_shuoshuo", j3);
        r(b16, "_shuoshuo", j3);
        t(b16, "_shuoshuo", j3);
        u(b16, "key_shuoshuo_timer", j3);
        l(d16, "_shuoshuo", j3);
        g(d16, "_shuoshuo", j3);
        h(d16, "_shuoshuo", j3);
        m(d16, "_shuoshuo", j3);
        n(b16, "_shuoshuo", j3);
        o(d16, "_shuoshuo", j3);
        x(b16, "_shuoshuo", j3);
        z(b16, "_shuoshuo", j3);
        y(b16, "_shuoshuo", j3);
        w(b16, "_shuoshuo", j3);
        e(b16, "_shuoshuo", j3);
        d(b16, "_shuoshuo", j3);
        c(b16, "_shuoshuo", j3);
        i(b16, "_shuoshuo", j3);
        b16.commit();
        d16.commit();
    }

    public static String j0(String str, String str2, long j3) {
        return c.u(str, str2, j3);
    }

    private static void k(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("key_shuoshuo_draft" + str + "_" + j3);
    }

    public static HashMap<String, Boolean> k0(String str, long j3) {
        String h06 = h0("key_shuoshuo_markhascheckfacesmap" + str + "_" + j3, "");
        HashMap<String, Boolean> hashMap = null;
        if (TextUtils.isEmpty(h06)) {
            return null;
        }
        byte[] decode = Base64.decode(h06, 0);
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            hashMap = ParcelableWrapper.readHashMap(obtain, ParcelableWrapper.class.getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            return hashMap;
        } catch (Exception e16) {
            QZLog.w(e16);
            return hashMap;
        }
    }

    private static void l(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("shuoshuo_event_tag_title" + str + "_" + j3);
        editor.remove("shuoshuo_event_tag_desc" + str + "_" + j3);
        editor.remove("shuoshuo_event_tag_desc_truncate_num" + str + "_" + j3);
        editor.remove("shuoshuo_event_tag_protocol" + str + "_" + j3);
    }

    public static HashMap<String, Boolean> l0(String str, long j3) {
        String h06 = h0("key_shuoshuo_markNeedShowFaceIconMap" + str + "_" + j3, "");
        HashMap<String, Boolean> hashMap = null;
        if (TextUtils.isEmpty(h06)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(h06, 0);
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            hashMap = ParcelableWrapper.readHashMap(obtain, ParcelableWrapper.class.getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            return hashMap;
        } catch (Exception e16) {
            QZLog.w(e16);
            return hashMap;
        }
    }

    private static void m(SharedPreferences.Editor editor, String str, long j3) {
        z0("key_shuoshuo_selected_media" + str + "_" + j3);
    }

    public static HashMap<String, ArrayList<FaceData>> m0(String str, long j3) {
        String h06 = h0("key_shuoshuo_marksfacedatamap" + str + "_" + j3, "");
        HashMap<String, ArrayList<FaceData>> hashMap = null;
        if (TextUtils.isEmpty(h06)) {
            return null;
        }
        byte[] decode = Base64.decode(h06, 0);
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            hashMap = ParcelableWrapper.readHashMap(obtain, ParcelableWrapper.class.getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            return hashMap;
        } catch (Exception e16) {
            QZLog.w(e16);
            return hashMap;
        }
    }

    private static void n(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("key_shuoshuo_right" + str + "_" + j3);
    }

    public static HashMap<String, MarkUinInfoBeforeUpload> n0(String str, long j3) {
        String h06 = h0("key_shuoshuo_upload_map" + str + "_" + j3, "");
        HashMap<String, MarkUinInfoBeforeUpload> hashMap = null;
        if (TextUtils.isEmpty(h06)) {
            return null;
        }
        byte[] decode = Base64.decode(h06, 0);
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            hashMap = ParcelableWrapper.readHashMap(obtain, ParcelableWrapper.class.getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            return hashMap;
        } catch (Exception e16) {
            QZLog.w(e16);
            return hashMap;
        }
    }

    private static void o(SharedPreferences.Editor editor, String str, long j3) {
        int H = H("key_shuoshuo_right_uin_list_size" + str, 0, j3);
        if (H > 0) {
            for (int i3 = 0; i3 < H; i3++) {
                editor.remove("key_shuoshuo_right_uin_list" + str + i3);
            }
        }
        editor.remove("key_shuoshuo_right_uin_list_size" + str);
    }

    public static void o0(String str, boolean z16) {
        c.B(str, z16);
    }

    private static void p(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("key_shuoshuo_selected_images" + str + "_" + j3);
    }

    public static void p0(String str, boolean z16, long j3) {
        c.C(str, z16, j3);
    }

    public static void q(String str, long j3) {
        z0("key_shuoshuo_selected_images" + str + "_" + j3);
    }

    public static void q0(String str, int i3) {
        c.D(str, i3);
    }

    private static void r(SharedPreferences.Editor editor, String str, long j3) {
        z0("key_shuoshuo_selected_video" + str + "_" + j3);
    }

    public static void r0(String str, int i3, long j3) {
        c.F(str, i3, j3);
    }

    private static void s(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("shuoshuo_uistate" + str + "_" + j3);
    }

    public static void s0(String str, long j3) {
        c.G(str, j3);
    }

    public static void t(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("mood_status" + str + "_" + j3);
    }

    public static void t0(String str, String str2, long j3) {
        c.H(str, str2, j3);
    }

    private static void u(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("key_shuoshuo_timer" + str + "_" + j3);
    }

    public static void u0(String str, long j3, long j16) {
        c.I(str, j3, j16);
    }

    private static void v(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("key_shuoshuo_title_draft" + str + "_" + j3);
    }

    public static void v0(String str, String str2) {
        c.J(str, str2);
    }

    private static void w(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("key_shuoshuo_shootinfo_dianping_id" + str + "_" + j3);
    }

    public static void w0(String str, String str2, String str3) {
        c.K(str, str2, str3);
    }

    private static void x(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("key_shuoshuo_shootinf_lbs" + str + "_" + j3);
    }

    public static void x0(String str, String str2, long j3) {
        c.L(str, str2, j3);
    }

    private static void y(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("key_shuoshuo_shootinfo_poi_id" + str + "_" + j3);
    }

    public static void y0(HashMap<String, String> hashMap) {
        c.M(hashMap);
    }

    private static void z(SharedPreferences.Editor editor, String str, long j3) {
        editor.remove("key_shuoshuo_shootinfo_time_and_weather" + str + "_" + j3);
    }

    public static void z0(String str) {
        c.P(str);
    }

    private static void H0(SharedPreferences.Editor editor, String str, HashMap<String, Boolean> hashMap, long j3) {
        if (hashMap == null || hashMap.size() == 0) {
            return;
        }
        HashMap hashMap2 = new HashMap(hashMap);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeMap(obtain, hashMap2);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        editor.putString("key_shuoshuo_markhascheckfacesmap" + str + "_" + j3, Base64.encodeToString(marshall, 0));
    }

    private static void I0(SharedPreferences.Editor editor, String str, HashMap<String, Boolean> hashMap, long j3) {
        if (hashMap == null || hashMap.size() == 0) {
            return;
        }
        HashMap hashMap2 = new HashMap(hashMap);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeMap(obtain, hashMap2);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        editor.putString("key_shuoshuo_markNeedShowFaceIconMap" + str + "_" + j3, Base64.encodeToString(marshall, 0));
    }

    private static void J0(SharedPreferences.Editor editor, String str, HashMap<String, ArrayList<FaceData>> hashMap, long j3) {
        if (hashMap == null || hashMap.size() == 0) {
            return;
        }
        HashMap hashMap2 = new HashMap(hashMap);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeMap(obtain, hashMap2);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        editor.putString("key_shuoshuo_marksfacedatamap" + str + "_" + j3, Base64.encodeToString(marshall, 0));
    }

    private static void K0(SharedPreferences.Editor editor, String str, HashMap<String, MarkUinInfoBeforeUpload> hashMap, long j3) {
        if (hashMap == null || hashMap.size() == 0) {
            return;
        }
        HashMap hashMap2 = new HashMap(hashMap);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeMap(obtain, hashMap2);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        editor.putString("key_shuoshuo_upload_map" + str + "_" + j3, Base64.encodeToString(marshall, 0));
    }

    public static void N0(ShuoshuoContent shuoshuoContent, long j3) {
        SharedPreferences.Editor b16 = c.b();
        SharedPreferences.Editor d16 = c.d(j3);
        b16.putInt(QZonePublishMoodActivity.Vo("shuoshuo_sync_bits", j3), shuoshuoContent.getSyncBit());
        b16.putBoolean(QZonePublishMoodActivity.Vo("shuoshuo_egg_layout_switch", j3), shuoshuoContent.getEggLayoutSwitch());
        O0(b16, "_shuoshuo", shuoshuoContent.getTextDraft(), j3);
        b1(b16, "_shuoshuo", shuoshuoContent.getSelectedImage(), j3, shuoshuoContent.getEggsUrlMap());
        B0(d16, "_shuoshuo", shuoshuoContent.getAtFriends(), j3);
        e1(b16, "_shuoshuo", shuoshuoContent.getVideoInfo(), j3);
        d1(b16, "_shuoshuo", shuoshuoContent.getSelectedQzonePhotos(), j3);
        c1(b16, "_shuoshuo", shuoshuoContent.getSelectedMeidaInfo(), j3);
        Z0(b16, "_shuoshuo", shuoshuoContent.getRecordedVideoInfoMap(), j3);
        a1(b16, "_shuoshuo", shuoshuoContent.getSelectedVideoInfoMap(), j3);
        U0(b16, "key_shuoshuo_timer", shuoshuoContent.getTimer(), j3);
        R0(b16, "_shuoshuo", shuoshuoContent.getmPriv(), j3);
        S0(d16, "_shuoshuo", shuoshuoContent.getmPrivUinList(), j3);
        String imageShootInfoLbs = shuoshuoContent.getImageShootInfoLbs();
        if (imageShootInfoLbs != null) {
            W0(b16, "_shuoshuo", imageShootInfoLbs, j3);
        }
        String imageShootInfoDateAndWeather = shuoshuoContent.getImageShootInfoDateAndWeather();
        if (imageShootInfoDateAndWeather != null) {
            Y0(b16, "_shuoshuo", imageShootInfoDateAndWeather, j3);
        }
        LbsDataV2.PoiInfo poiInfo = shuoshuoContent.getmCurrentShootPoiInfo();
        LbsDataV2.PoiInfo currentPoiInfo = shuoshuoContent.getCurrentPoiInfo();
        if (poiInfo != null) {
            X0(b16, "_shuoshuo", poiInfo.poiId, j3);
            V0(b16, "_shuoshuo", poiInfo.dianPingId, j3);
        } else if (currentPoiInfo != null) {
            X0(b16, "_shuoshuo", currentPoiInfo.poiId, j3);
            V0(b16, "_shuoshuo", currentPoiInfo.dianPingId, j3);
        }
        T0(d16, "_shuoshuo", shuoshuoContent.getState(), j3);
        PublishEventTag eventTag = shuoshuoContent.getEventTag();
        if (eventTag != null) {
            Q0(d16, "_shuoshuo", j3, eventTag.title, eventTag.desc, eventTag.descTruncateNum, eventTag.f45887protocol, eventTag.picUrl, eventTag.f45886id);
        }
        HashMap<String, Boolean> hashMap = shuoshuoContent.getmMarkHasCheckFacesMap();
        if (hashMap != null) {
            H0(b16, "_shuoshuo", hashMap, j3);
        }
        HashMap<String, ArrayList<FaceData>> hashMap2 = shuoshuoContent.getmMarksFaceDataMap();
        if (hashMap != null) {
            J0(b16, "_shuoshuo", hashMap2, j3);
        }
        HashMap<String, MarkUinInfoBeforeUpload> hashMap3 = shuoshuoContent.getmMarksUploadMap();
        if (hashMap != null) {
            K0(b16, "_shuoshuo", hashMap3, j3);
        }
        HashMap<String, Boolean> hashMap4 = shuoshuoContent.getmMarkNeedShowFaceIconMap();
        if (hashMap4 != null) {
            I0(b16, "_shuoshuo", hashMap4, j3);
        }
        M0(b16, "_shuoshuo", shuoshuoContent.getShowType(), j3);
        b16.commit();
        d16.commit();
    }

    private static void Z0(SharedPreferences.Editor editor, String str, Map<String, ShuoshuoVideoInfo> map, long j3) {
        if (map == null || map.size() == 0) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeMap(obtain, hashMap);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        editor.putString("key_shuoshuo_record_media" + str + "_" + j3, Base64.encodeToString(marshall, 0));
    }

    private static void a1(SharedPreferences.Editor editor, String str, Map<String, ShuoshuoVideoInfo> map, long j3) {
        if (map == null || map.size() == 0) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeMap(obtain, hashMap);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        editor.putString("key_shuoshuo_select_list_media" + str + "_" + j3, Base64.encodeToString(marshall, 0));
    }

    private static void b1(SharedPreferences.Editor editor, String str, List<String> list, long j3, HashMap<String, PicInfo> hashMap) {
        String str2;
        if (list != null && list.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (String str3 : list) {
                if (!TextUtils.isEmpty(str3) && !str3.startsWith("http://") && !str3.startsWith("https://")) {
                    sb5.append(str3);
                    sb5.append("|");
                } else if (!TextUtils.isEmpty(str3) && (str3.startsWith("http://") || str3.startsWith("https://"))) {
                    if (hashMap != null && hashMap.get(str3) != null) {
                        PicInfo picInfo = hashMap.get(str3);
                        int i3 = picInfo.sourceType;
                        if (i3 == 2) {
                            str2 = picInfo.sourceType + "<" + picInfo.pic_url + "<" + picInfo.imageId + "<" + picInfo.picwidth + "<" + picInfo.picheight;
                        } else if (i3 == 1) {
                            str2 = picInfo.sourceType + "<" + str3 + "<" + picInfo.imageId;
                        } else {
                            str2 = "";
                        }
                        sb5.append(str2);
                        sb5.append("|");
                    } else {
                        sb5.append(str3);
                        sb5.append("|");
                    }
                }
            }
            int lastIndexOf = sb5.lastIndexOf("|");
            if (lastIndexOf != -1) {
                editor.putString("key_shuoshuo_selected_images" + str + "_" + j3, sb5.substring(0, lastIndexOf));
                return;
            }
            return;
        }
        p(editor, str, j3);
    }

    private static void c1(SharedPreferences.Editor editor, String str, Map<String, LocalMediaInfo> map, long j3) {
        if (map == null || map.size() == 0) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeMap(obtain, hashMap);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        editor.putString("key_shuoshuo_selected_media" + str + "_" + j3, Base64.encodeToString(marshall, 0));
    }

    private static void d1(SharedPreferences.Editor editor, String str, Map<String, PicInfo> map, long j3) {
        if (map == null || map.size() == 0) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeMap(obtain, hashMap);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        editor.putString("key_shuoshuo_selected_qzone_photo" + str + "_" + j3, Base64.encodeToString(marshall, 0));
    }

    private static void e1(SharedPreferences.Editor editor, String str, ShuoshuoVideoInfo shuoshuoVideoInfo, long j3) {
        if (shuoshuoVideoInfo == null) {
            r(editor, str, j3);
            return;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, shuoshuoVideoInfo);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        editor.putString("key_shuoshuo_selected_video" + str + "_" + j3, Base64.encodeToString(marshall, 0));
    }

    private static void B0(SharedPreferences.Editor editor, String str, List<Friend> list, long j3) {
        if (list == null) {
            return;
        }
        int size = list.size();
        editor.putInt("key_at_friends_size" + str, size);
        for (int i3 = 0; i3 < size; i3++) {
            Friend friend = list.get(i3);
            if (friend != null) {
                editor.putLong("key_at_friends_uin" + str + i3, friend.mUin);
                editor.putString("key_at_friends_name" + str + i3, friend.mName);
            }
        }
    }

    private static void S0(SharedPreferences.Editor editor, String str, List<String> list, long j3) {
        if (list == null) {
            return;
        }
        int size = list.size();
        editor.putInt("key_shuoshuo_right_uin_list_size" + str, size);
        for (int i3 = 0; i3 < size; i3++) {
            editor.putString("key_shuoshuo_right_uin_list" + str + i3, list.get(i3));
        }
    }
}

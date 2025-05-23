package wk;

import android.os.Bundle;
import com.qzone.common.business.service.media.c;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.MediaMimeType;
import com.tencent.mobileqq.wink.picker.QZoneInitBean;
import com.tencent.mobileqq.wink.picker.TabType;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.media.QZoneMediaBusiness;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f445742a = "";

    /* compiled from: P */
    /* renamed from: wk.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    static /* synthetic */ class C11490a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f445743a;

        static {
            int[] iArr = new int[QZoneMediaBusiness.values().length];
            f445743a = iArr;
            try {
                iArr[QZoneMediaBusiness.QZONE_COMMENT_ADD_PIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_VIDEO_ALBUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_SHUOSHUO_LONGPIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_MYSHUOSHUO_LIST_PHOTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_SHUOSHUO_UPLOAD_PIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_SHUOSHUO_MAKE_VIDEO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_ALBUM_LIST.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_ALBUM_UPLOAD_PIC.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_ALBUM_DETAIL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_PANEL_ALBUM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_ALBUM_LIST_ONLY_VIDEO.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_PUBLISH_INTIMATE_MOOD.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_INTIMATE_UPLOAD_ALBUM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_GROUP_UPLOAD_ALBUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f445743a[QZoneMediaBusiness.QZONE_ALBUMX_UPLOAD_ALBUM.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    private void a(Bundle bundle, ArrayList<String> arrayList) {
        Config.a r16 = r();
        w(r16, bundle, 1000);
        r16.d(arrayList);
        bundle.putSerializable("QZONE_MEDIA_PICKER_CONFIG", r16.a());
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", new QZoneInitBean(true, 0, r16.getMaxSelectMediaSize(), true, 0, 35, ""));
    }

    private void b(Bundle bundle, ArrayList<String> arrayList) {
        Config.a u16 = u();
        w(u16, bundle, 50);
        u16.d(arrayList);
        bundle.putSerializable("QZONE_MEDIA_PICKER_CONFIG", u16.a());
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", new QZoneInitBean(true, 0, u16.getMaxSelectMediaSize(), false, 0, 35, ""));
    }

    private void c(Bundle bundle) {
        b.f445744a.c(QQWinkConstants.HOME_SHOW_PICKER_TAB, bundle);
        Config.a p16 = p(true);
        w(p16, bundle, 3);
        bundle.putSerializable("QZONE_MEDIA_PICKER_CONFIG", p16.a());
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", new QZoneInitBean(true, 0, p16.getMaxSelectMediaSize(), false, 0, 35, ""));
    }

    private void d(Bundle bundle) {
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, false);
        Config.a p16 = p(true);
        w(p16, bundle, 60);
        bundle.putSerializable("QZONE_MEDIA_PICKER_CONFIG", p16.a());
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", new QZoneInitBean(true, 0, p16.getMaxSelectMediaSize(), false, 0, 35, ""));
    }

    private void e(c cVar, int i3) {
        if (cVar.f45832e == null) {
            cVar.f45832e = new Bundle();
        }
        Bundle bundle = cVar.f45832e;
        Config.a t16 = t(cVar);
        t16.p(cVar.f45833f);
        w(t16, bundle, i3);
        t16.d(cVar.f45830c);
        bundle.putSerializable("QZONE_MEDIA_PICKER_CONFIG", t16.a());
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, true);
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_PICKER_TAB, true);
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_TEMPLATE_TAB, false);
        QZoneInitBean qZoneInitBean = new QZoneInitBean(true, 0, t16.getMaxSelectMediaSize(), true, 0, 35, "");
        f445742a = "";
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", qZoneInitBean);
    }

    private void f(c cVar, int i3) {
        if (cVar.f45832e == null) {
            cVar.f45832e = new Bundle();
        }
        Bundle bundle = cVar.f45832e;
        Config.a t16 = t(cVar);
        t16.p(cVar.f45833f);
        w(t16, bundle, i3);
        t16.d(cVar.f45830c);
        bundle.putSerializable("QZONE_MEDIA_PICKER_CONFIG", t16.a());
        QZoneInitBean qZoneInitBean = new QZoneInitBean(true, 0, t16.getMaxSelectMediaSize(), true, 0, 35, "");
        f445742a = "";
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", qZoneInitBean);
    }

    private void g(Bundle bundle, ArrayList<String> arrayList) {
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, false);
        Config.a p16 = p(true);
        p16.j(30);
        p16.m(TabType.ONLY_IMAGE);
        p16.d(arrayList);
        bundle.putSerializable("QZONE_MEDIA_PICKER_CONFIG", p16.a());
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", new QZoneInitBean(true, 3, p16.getMaxSelectMediaSize(), false, 0, 35, ""));
    }

    private void j(c cVar, int i3) {
        if (cVar.f45832e == null) {
            cVar.f45832e = new Bundle();
        }
        Bundle bundle = cVar.f45832e;
        Config.a t16 = t(cVar);
        t16.p(cVar.f45833f);
        w(t16, bundle, i3);
        t16.d(cVar.f45830c);
        bundle.putSerializable("WINK_MEDIA_PICKER_CONFIG", t16.a());
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, true);
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_PICKER_TAB, true);
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_TEMPLATE_TAB, true);
        QZoneInitBean qZoneInitBean = new QZoneInitBean(true, 0, t16.getMaxSelectMediaSize(), true, 0, 35, "");
        f445742a = "";
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", qZoneInitBean);
    }

    private Config.a m() {
        Config.a aVar = new Config.a();
        aVar.k(true);
        return aVar;
    }

    private MediaFilter.a n(List<MediaMimeType> list) {
        MediaFilter.a aVar = new MediaFilter.a();
        aVar.f(list);
        return aVar;
    }

    private MediaFilter.a o() {
        MediaFilter.a aVar = new MediaFilter.a();
        aVar.g(QZoneHelper.getVideoCanUploadLimitMs());
        aVar.k(QZoneHelper.getVideoCanUploadSize());
        return aVar;
    }

    private Config.a p(boolean z16) {
        Config.a m3 = m();
        MediaFilter.a o16 = o();
        List<MediaMimeType> q16 = q(z16);
        o16.f(q16);
        m3.n(n(q16).a());
        m3.o(o16.a());
        m3.i(TabType.ONLY_IMAGE);
        return m3;
    }

    private List<MediaMimeType> q(boolean z16) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MediaMimeType.IMAGE_PNG);
        arrayList.add(MediaMimeType.IMAGE_WEBP);
        if (z16) {
            arrayList.add(MediaMimeType.IMAGE_GIF);
        }
        arrayList.add(MediaMimeType.IMAGE_HEIF);
        arrayList.add(MediaMimeType.IMAGE_JPEG);
        return arrayList;
    }

    private Config.a r() {
        Config.a m3 = m();
        MediaFilter.a o16 = o();
        List<MediaMimeType> s16 = s();
        o16.f(s16);
        m3.n(n(s16).a());
        m3.o(o16.a());
        return m3;
    }

    private List<MediaMimeType> s() {
        List<MediaMimeType> v3 = v();
        v3.addAll(q(true));
        return v3;
    }

    private Config.a t(c cVar) {
        int i3 = cVar.f45834g;
        if (i3 == 1) {
            return p(true);
        }
        if (i3 == 2) {
            return u();
        }
        return r();
    }

    private Config.a u() {
        Config.a m3 = m();
        MediaFilter.a o16 = o();
        List<MediaMimeType> v3 = v();
        o16.f(v3);
        m3.n(n(v3).a());
        m3.o(o16.a());
        m3.i(TabType.ONLY_VIDEO);
        return m3;
    }

    private List<MediaMimeType> v() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MediaMimeType.VIDEO_MP4);
        return arrayList;
    }

    private void w(Config.a aVar, Bundle bundle, int i3) {
        int i16 = bundle.getInt("PICKER_MAX_COUNT_SUPPORT", 0);
        if (i16 != 0) {
            i3 = i16;
        }
        aVar.j(i3);
    }

    public void l(Bundle bundle, QZoneMediaBusiness qZoneMediaBusiness) {
        if (qZoneMediaBusiness == QZoneMediaBusiness.QZONE_SHUOSHUO_CAMERA) {
            b.f445744a.c(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, bundle);
        }
        bundle.putString("xsj_ref_pgid", qZoneMediaBusiness.getBusinessName());
        bundle.putString("AECAMERA_TAB_SELECTED", "0");
        Config.a r16 = r();
        w(r16, bundle, 50);
        bundle.putSerializable("QZONE_MEDIA_PICKER_CONFIG", r16.a());
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", new QZoneInitBean(true, 0, r16.getMaxSelectMediaSize(), true, 0, 35, ""));
    }

    private void h(Bundle bundle) {
        Config.a r16 = r();
        w(r16, bundle, 35);
        bundle.putSerializable("QZONE_MEDIA_PICKER_CONFIG", r16.a());
        bundle.putBoolean("needRemoveAllLocalPathWhenExport", false);
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", new QZoneInitBean(false, 0, r16.getMaxSelectMediaSize(), true, 0, 35, 10, false, "", false, true, false, false));
        bundle.putBoolean("needRemoveOriginPath", false);
    }

    private void i(Bundle bundle, ArrayList<String> arrayList) {
        Config.a r16 = r();
        w(r16, bundle, 500);
        r16.m(TabType.ONLY_IMAGE);
        r16.d(arrayList);
        bundle.putSerializable("QZONE_MEDIA_PICKER_CONFIG", r16.a());
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", new QZoneInitBean(true, 0, r16.getMaxSelectMediaSize(), true, 0, 35, 10, false, "", false, true, false, bundle.getBoolean(PeakConstants.SHOW_QZONE_MEDIA_PICKER_PUBLISH_TEXT_MOOD_ENTRANCE, false)));
    }

    public void k(c cVar) {
        if (cVar == null) {
            return;
        }
        if (cVar.f45832e == null) {
            cVar.f45832e = new Bundle();
        }
        Bundle bundle = cVar.f45832e;
        bundle.putString("AECAMERA_TAB_SELECTED", "1");
        bundle.putSerializable("WINK_MEDIA_PICKER_SELECT_QZONE_PHOTO", cVar.f45831d);
        ArrayList<String> arrayList = cVar.f45830c;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        bundle.putString("xsj_ref_pgid", cVar.f45829b.getBusinessName());
        switch (C11490a.f445743a[cVar.f45829b.ordinal()]) {
            case 1:
                c(bundle);
                return;
            case 2:
                d(bundle);
                return;
            case 3:
                g(bundle, arrayList);
                return;
            case 4:
            case 5:
                i(bundle, arrayList);
                return;
            case 6:
                h(bundle);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
                a(bundle, arrayList);
                return;
            case 11:
                b(bundle, arrayList);
                return;
            case 12:
                f(cVar, 9);
                return;
            case 13:
                f(cVar, yl.a.o());
                return;
            case 14:
                e(cVar, 100);
                return;
            case 15:
                j(cVar, 1000);
                return;
            default:
                i(bundle, arrayList);
                return;
        }
    }
}

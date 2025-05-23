package ry4;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.component.utils.LogUtil;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import common.config.service.QzoneConfig;
import java.util.StringTokenizer;

/* compiled from: P */
/* loaded from: classes27.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static c f432967d;

    /* renamed from: e, reason: collision with root package name */
    private static final int[][] f432968e = {new int[]{200, 1000, 500, g.V0, 1000, 1500}, new int[]{5000, g.V0, 1200, g.V0, QQLiveError.UPLOAD_BITMAP_DOING, 1200}, new int[]{g.V0, 8192, 1000, 4000, QQLiveError.UPLOAD_BITMAP_DOING, 1500}, new int[]{2500, 3000, 1500, 4000, 5000, 1500}, new int[]{QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES, 5500, 1500, 5000, 5500, 1500}, new int[]{4000, 3000, 1000, 2500, 5500, 1200}, new int[]{500, 5000, 800, g.V0, 3000, 1200}, new int[]{20, 500, 60, g.V0, 5000, 1500}};

    /* renamed from: f, reason: collision with root package name */
    private static final int[][] f432969f = {new int[]{0, 0, 0, 2, 2}, new int[]{0, 0, 0, 0, 0}, new int[]{3, 4, 2, 0, -3}, new int[]{3, 2, 0, 0, 2}, new int[]{3, 2, 0, -1, -3}, new int[]{2, 2, 2, 0, 0}, new int[]{5, 2, -2, 1, 3}, new int[]{-2, 0, 1, 2, 1}};

    /* renamed from: g, reason: collision with root package name */
    private static final int[][] f432970g = {new int[]{g.T0, 150, 1500, 2000}};

    /* renamed from: a, reason: collision with root package name */
    private final Object f432971a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private AudioManager f432972b;

    /* renamed from: c, reason: collision with root package name */
    private Context f432973c;

    public c(Context context) {
        this.f432973c = context;
        this.f432972b = (AudioManager) context.getSystemService("audio");
    }

    public static c b(Context context) {
        if (f432967d == null) {
            f432967d = new c(context);
        }
        return f432967d;
    }

    private int c(String str) {
        if (Build.MANUFACTURER.trim().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
            try {
                String parameters = this.f432972b.getParameters(str);
                LogUtil.v("VivoKTVHelper", "getKTVParam: " + parameters);
                StringTokenizer stringTokenizer = new StringTokenizer(parameters, ContainerUtils.KEY_VALUE_DELIMITER);
                if (stringTokenizer.countTokens() != 2) {
                    LogUtil.e("VivoKTVHelper", "getKTVParam: malformated string " + parameters);
                } else if (str.equals(stringTokenizer.nextToken())) {
                    return Integer.parseInt(stringTokenizer.nextToken().trim());
                }
            } catch (Exception e16) {
                LogUtil.i("VivoKTVHelper", "getKTVParam -> exception happen:" + e16.getMessage());
            }
        }
        return 0;
    }

    private void i(int i3) {
        AudioManager audioManager = this.f432972b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("vivo_ktv_miceq_band1=");
        int[][] iArr = f432969f;
        sb5.append(iArr[i3][0] + 8);
        audioManager.setParameters(sb5.toString());
        this.f432972b.setParameters("vivo_ktv_miceq_band2=" + (iArr[i3][1] + 8));
        this.f432972b.setParameters("vivo_ktv_miceq_band3=" + (iArr[i3][2] + 8));
        this.f432972b.setParameters("vivo_ktv_miceq_band4=" + (iArr[i3][3] + 8));
        this.f432972b.setParameters("vivo_ktv_miceq_band5=" + (iArr[i3][4] + 8));
    }

    private void j(int i3) {
        if (i3 == 4) {
            this.f432972b.setParameters("vivo_ktv_echo_enable=1");
            AudioManager audioManager = this.f432972b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("vivo_ktv_echo_feedback=");
            int[][] iArr = f432970g;
            sb5.append(iArr[0][0]);
            audioManager.setParameters(sb5.toString());
            this.f432972b.setParameters("vivo_ktv_echo_delay=" + iArr[0][1]);
            this.f432972b.setParameters("vivo_ktv_echo_wet=" + iArr[0][2]);
            this.f432972b.setParameters("vivo_ktv_echo_dry=" + iArr[0][3]);
        }
    }

    private void l(int i3) {
        if (i3 == 7) {
            this.f432972b.setParameters("vivo_ktv_reverb_preset=4");
        } else {
            this.f432972b.setParameters("vivo_ktv_reverb_preset=0");
        }
    }

    private void o(int i3) {
        AudioManager audioManager = this.f432972b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("vivo_ktv_rb_roomsize=");
        int[][] iArr = f432968e;
        sb5.append(iArr[i3][0]);
        audioManager.setParameters(sb5.toString());
        this.f432972b.setParameters("vivo_ktv_rb_damp=" + iArr[i3][1]);
        this.f432972b.setParameters("vivo_ktv_rb_wet=" + iArr[i3][2]);
        this.f432972b.setParameters("vivo_ktv_rb_dry=" + iArr[i3][3]);
        this.f432972b.setParameters("vivo_ktv_rb_width=" + iArr[i3][4]);
        this.f432972b.setParameters("vivo_ktv_rb_gain=" + iArr[i3][5]);
        this.f432972b.setParameters("vivo_ktv_echo_enable=0");
    }

    public void a() {
        this.f432972b.setParameters("vivo_ktv_mode=0");
    }

    public int d() {
        return c("vivo_ktv_play_source");
    }

    public int e() {
        return c("vivo_ktv_preset_effect");
    }

    public boolean f() {
        int parseInt;
        if (Build.MANUFACTURER.trim().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(this.f432972b.getParameters("vivo_ktv_mic_type"), ContainerUtils.KEY_VALUE_DELIMITER);
                if (stringTokenizer.countTokens() == 2 && stringTokenizer.nextToken().equals("vivo_ktv_mic_type") && ((parseInt = Integer.parseInt(stringTokenizer.nextToken())) == 1 || parseInt == 0)) {
                    return true;
                }
            } catch (Exception e16) {
                LogUtil.i("VivoKTVHelper", "isDeviceSupportKaraoke -> exception happen:" + e16.getMessage());
            }
        }
        return false;
    }

    public void g() {
        this.f432972b.setParameters("vivo_ktv_mode=1");
    }

    public void h(int i3) {
        LogUtil.v("VivoKTVHelper", "setCustomMode: " + i3);
        if (i3 < 0 || i3 > 7) {
            i3 = 0;
        }
        synchronized (this.f432971a) {
            k(0);
            l(i3);
            o(i3);
            i(i3);
            j(i3);
        }
    }

    public void k(int i3) {
        synchronized (this.f432971a) {
            if (this.f432972b != null) {
                this.f432972b.setParameters("vivo_ktv_ext_speaker" + ContainerUtils.KEY_VALUE_DELIMITER + i3);
            }
        }
    }

    public void m(int i3) {
        synchronized (this.f432971a) {
            if (this.f432972b != null) {
                this.f432972b.setParameters("vivo_ktv_volume_mic" + ContainerUtils.KEY_VALUE_DELIMITER + i3);
            }
        }
    }

    public void n(int i3) {
        synchronized (this.f432971a) {
            AudioManager audioManager = this.f432972b;
            if (audioManager != null) {
                audioManager.setParameters("vivo_ktv_play_source=" + i3);
            }
        }
    }

    public void p(int i3) {
        synchronized (this.f432971a) {
            AudioManager audioManager = this.f432972b;
            if (audioManager != null) {
                audioManager.setParameters("vivo_ktv_rec_source=" + i3);
            }
        }
    }
}

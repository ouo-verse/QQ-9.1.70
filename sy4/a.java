package sy4;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f434977a = "audio_karaoke_enable";

    /* renamed from: b, reason: collision with root package name */
    private final String f434978b = "audio_karaoke_volume";

    /* renamed from: c, reason: collision with root package name */
    private final String f434979c = "audio_karaoke_EQ";

    /* renamed from: d, reason: collision with root package name */
    private final String f434980d = "audio_karaoke_Reverb";

    /* renamed from: e, reason: collision with root package name */
    private final String f434981e = "audio_karaoke_support";

    /* renamed from: f, reason: collision with root package name */
    private final String f434982f = "karaoke_app_support";

    /* renamed from: g, reason: collision with root package name */
    private final String f434983g = "audio_karaoke_ktvmode";

    /* renamed from: h, reason: collision with root package name */
    private final int f434984h = 15;

    /* renamed from: i, reason: collision with root package name */
    private final int f434985i = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f434986j = false;

    /* renamed from: k, reason: collision with root package name */
    private int f434987k;

    /* renamed from: l, reason: collision with root package name */
    private int f434988l;

    /* renamed from: m, reason: collision with root package name */
    private int f434989m;

    /* renamed from: n, reason: collision with root package name */
    private int f434990n;

    /* renamed from: o, reason: collision with root package name */
    private ContentResolver f434991o;

    /* renamed from: p, reason: collision with root package name */
    private Context f434992p;

    /* renamed from: q, reason: collision with root package name */
    private SharedPreferences f434993q;

    /* renamed from: r, reason: collision with root package name */
    private AudioManager f434994r;

    public a(Context context) {
        this.f434992p = context;
        this.f434991o = context.getContentResolver();
        this.f434994r = (AudioManager) this.f434992p.getSystemService("audio");
        this.f434993q = this.f434992p.getSharedPreferences("loopback_mode", 0);
    }

    public static a b(Context context) {
        return new a(context);
    }

    public void a() {
        this.f434994r.setParameters("audio_karaoke_ktvmode=disable");
        this.f434986j = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        if (this.f434987k == 1) {
            return 1;
        }
        return 0;
    }

    public void d() {
        if (this.f434986j) {
            return;
        }
        this.f434988l = this.f434993q.getInt("audio_karaoke_volume", 50);
        this.f434989m = this.f434993q.getInt("audio_karaoke_EQ", 0);
        this.f434990n = this.f434993q.getInt("audio_karaoke_Reverb", 0);
        this.f434994r.setParameters("audio_karaoke_ktvmode=enable");
        this.f434994r.setParameters("audio_karaoke_volume=" + this.f434988l);
        this.f434994r.setParameters("audio_karaoke_EQ=" + this.f434989m);
        this.f434994r.setParameters("audio_karaoke_Reverb=" + this.f434990n);
        this.f434986j = true;
    }

    public void e(int i3) {
        if (i3 > 15) {
            i3 = 15;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (this.f434988l != i3 && this.f434987k == 1) {
            this.f434994r.setParameters("audio_karaoke_volume=" + i3);
            this.f434988l = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i3) {
        if (this.f434987k == i3) {
            return;
        }
        this.f434987k = i3;
        this.f434994r.setParameters("audio_karaoke_enable=" + i3);
    }
}

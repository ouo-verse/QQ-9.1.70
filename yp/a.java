package yp;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.d;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.a;
import com.tencent.qcircle.weseevideo.model.MediaConfig;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat;
import com.tencent.ttpic.voicechanger.common.audio.VoiceChanger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a implements a.b {

    /* renamed from: o, reason: collision with root package name */
    public static int f450756o;

    /* renamed from: p, reason: collision with root package name */
    public static int f450757p;

    /* renamed from: c, reason: collision with root package name */
    private int f450760c;

    /* renamed from: f, reason: collision with root package name */
    private String f450763f;

    /* renamed from: g, reason: collision with root package name */
    protected VoiceChanger f450764g;

    /* renamed from: h, reason: collision with root package name */
    private int f450765h;

    /* renamed from: j, reason: collision with root package name */
    private String f450767j;

    /* renamed from: k, reason: collision with root package name */
    private AudioCapture.b f450768k;

    /* renamed from: n, reason: collision with root package name */
    com.tencent.mobileqq.videocodec.mediacodec.recorder.a f450771n;

    /* renamed from: a, reason: collision with root package name */
    private final String f450758a = "AudioChangerManager";

    /* renamed from: b, reason: collision with root package name */
    private RandomAccessFile f450759b = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f450761d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f450762e = false;

    /* renamed from: i, reason: collision with root package name */
    private String f450766i = null;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f450769l = null;

    /* renamed from: m, reason: collision with root package name */
    private int f450770m = 0;

    static {
        int i3 = AudioRecorderCompat.SAMPLE_RATES[4];
        f450756o = i3;
        f450757p = (int) (i3 * 0.02d * 1.0d * 4.0d);
    }

    public a(String str, int i3, AudioCapture.b bVar) {
        this.f450767j = null;
        this.f450767j = FileUtils.genSeperateFileDir(str) + "audio_data_cache" + File.separator;
        this.f450768k = bVar;
    }

    private boolean f() {
        return (!g() || TextUtils.isEmpty(this.f450767j) || this.f450768k == null) ? false : true;
    }

    private boolean g() {
        try {
            File file = new File(this.f450767j);
            if (!file.exists()) {
                return file.mkdir();
            }
            if (!file.isFile()) {
                return true;
            }
            file.delete();
            return file.mkdir();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.a.b
    public void a() {
        ms.a.a("AudioChangerManager", "[onAudioFileEncodeFailed]");
        AudioCapture.b bVar = this.f450768k;
        if (bVar != null) {
            bVar.onAudioError(-6);
        }
        this.f450771n = null;
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.a.b
    public void b() {
        ms.a.a("AudioChangerManager", "[onAudioFileEncoded]");
        this.f450768k.onAudioChangeCaptured(this.f450763f);
        this.f450771n = null;
    }

    public void c(byte[] bArr, int i3, int i16) {
        byte[] bArr2;
        if (!e() || !f()) {
            return;
        }
        int i17 = 0;
        while (true) {
            int i18 = f450757p;
            if (i16 < i18) {
                if (i16 <= 0 || (bArr2 = this.f450769l) == null) {
                    return;
                }
                System.arraycopy(bArr, i17, bArr2, this.f450770m, i16);
                this.f450770m = i16;
                return;
            }
            byte[] bArr3 = this.f450769l;
            if (bArr3 == null) {
                return;
            }
            int i19 = this.f450770m;
            System.arraycopy(bArr, i17, bArr3, i19, i18 - i19);
            short[] sArr = new short[f450757p / 2];
            ByteBuffer.wrap(this.f450769l).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
            byte[] writeVoiceFrames = this.f450764g.writeVoiceFrames(sArr);
            if (writeVoiceFrames == null) {
                return;
            }
            try {
                if (!this.f450762e) {
                    this.f450759b.write(writeVoiceFrames, 0, writeVoiceFrames.length);
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            if (this.f450771n != null && this.f450762e) {
                byte[] bArr4 = new byte[writeVoiceFrames.length];
                System.arraycopy(writeVoiceFrames, 0, bArr4, 0, writeVoiceFrames.length);
                this.f450771n.f(bArr4, 0L);
            }
            int i26 = f450757p;
            int i27 = this.f450770m;
            i17 += i26 - i27;
            i16 -= i26 - i27;
            this.f450770m = 0;
        }
    }

    public void d() {
        if (f()) {
            this.f450766i = this.f450767j + VidUtil.generateVid() + MediaConfig.AUDIO_PCM_FILE_POSTFIX;
            this.f450764g = new VoiceChanger(this.f450766i, f450756o, this.f450760c, this.f450765h);
            try {
                this.f450759b = new RandomAccessFile(this.f450766i, "rw");
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
            }
            if (this.f450769l == null) {
                this.f450769l = new byte[f450757p];
            }
            this.f450770m = 0;
            if (this.f450762e && this.f450771n == null) {
                com.tencent.mobileqq.videocodec.mediacodec.recorder.a aVar = new com.tencent.mobileqq.videocodec.mediacodec.recorder.a();
                this.f450771n = aVar;
                aVar.l(CodecParam.mAudioSampleRate);
                this.f450771n.k(this);
                this.f450771n.h(this.f450763f);
                ms.a.a("AudioChangerManager", "New mHwAudioEncoder");
            }
        }
    }

    public boolean e() {
        return this.f450761d && d.t();
    }

    public void h(boolean z16, String str) {
        this.f450762e = z16;
        this.f450763f = str;
    }

    public void i(boolean z16, int i3, int i16) {
        this.f450761d = z16;
        this.f450760c = i3;
        this.f450765h = i16;
    }

    public void j() {
        VoiceChanger voiceChanger = this.f450764g;
        if (voiceChanger != null) {
            voiceChanger.release();
        }
        RandomAccessFile randomAccessFile = this.f450759b;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        this.f450769l = null;
        com.tencent.mobileqq.videocodec.mediacodec.recorder.a aVar = this.f450771n;
        if (aVar != null) {
            aVar.i();
        }
        if (this.f450762e) {
            return;
        }
        this.f450768k.onAudioChangeCaptured(this.f450766i);
    }
}

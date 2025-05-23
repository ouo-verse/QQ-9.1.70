package sz0;

import com.tencent.karaoke.decodesdk.M4AInformation;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class a {
    public abstract int decode(int i3, byte[] bArr);

    public abstract int decode(int i3, byte[] bArr, int i16, byte[] bArr2);

    public abstract int decodeSnapShot(int i3, byte[] bArr, int i16);

    public abstract M4AInformation getAudioInformation();

    public abstract int getCurrentTime();

    public abstract int getDecodePosition();

    public abstract int getDuration();

    public abstract int getFrameSize();

    public abstract int init(String str);

    public abstract int init(String str, String str2);

    public abstract int init(String str, String str2, boolean z16);

    public abstract int init(String str, boolean z16);

    public abstract int release();

    public abstract int seekTo(int i3);
}

package rd0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import qqlogin.nt_ldm.NTLoginDeviceManager$AutoLoginSwitch;
import qqlogin.nt_ldm.NTLoginDeviceManager$LoginApp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f431113a;

    /* renamed from: b, reason: collision with root package name */
    public int f431114b;

    /* renamed from: c, reason: collision with root package name */
    public int f431115c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f431116d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f431117e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f431118f;

    public NTLoginDeviceManager$AutoLoginSwitch a() {
        NTLoginDeviceManager$AutoLoginSwitch nTLoginDeviceManager$AutoLoginSwitch = new NTLoginDeviceManager$AutoLoginSwitch();
        NTLoginDeviceManager$LoginApp nTLoginDeviceManager$LoginApp = new NTLoginDeviceManager$LoginApp();
        nTLoginDeviceManager$LoginApp.app_id.set(this.f431115c);
        byte[] bArr = this.f431116d;
        if (bArr != null) {
            nTLoginDeviceManager$LoginApp.app_name.set(new String(bArr));
        }
        byte[] bArr2 = this.f431113a;
        if (bArr2 != null) {
            nTLoginDeviceManager$LoginApp.guid.set(ByteStringMicro.copyFrom(bArr2));
        }
        nTLoginDeviceManager$LoginApp.setHasFlag(true);
        nTLoginDeviceManager$AutoLoginSwitch.login_app.set(nTLoginDeviceManager$LoginApp);
        nTLoginDeviceManager$AutoLoginSwitch.encrypt_guid_version.set(this.f431114b);
        nTLoginDeviceManager$AutoLoginSwitch.setHasFlag(true);
        return nTLoginDeviceManager$AutoLoginSwitch;
    }

    public boolean b() {
        byte[] bArr;
        byte[] bArr2 = this.f431113a;
        if (bArr2 != null && bArr2.length > 0 && (bArr = this.f431116d) != null && bArr.length > 0 && this.f431115c > 0) {
            return false;
        }
        return true;
    }

    public void c(NTLoginDeviceManager$AutoLoginSwitch nTLoginDeviceManager$AutoLoginSwitch) {
        boolean z16;
        if (nTLoginDeviceManager$AutoLoginSwitch != null && nTLoginDeviceManager$AutoLoginSwitch.has() && nTLoginDeviceManager$AutoLoginSwitch.login_app.has()) {
            try {
                this.f431113a = nTLoginDeviceManager$AutoLoginSwitch.login_app.get().guid.get().toByteArray();
                this.f431114b = nTLoginDeviceManager$AutoLoginSwitch.encrypt_guid_version.get();
                this.f431115c = nTLoginDeviceManager$AutoLoginSwitch.login_app.get().app_id.get();
                this.f431116d = nTLoginDeviceManager$AutoLoginSwitch.login_app.app_name.get().getBytes(StandardCharsets.UTF_8);
                boolean z17 = false;
                if (nTLoginDeviceManager$AutoLoginSwitch.auto_login.get() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f431117e = z16;
                if (nTLoginDeviceManager$AutoLoginSwitch.trusted_device.get() == 1) {
                    z17 = true;
                }
                this.f431118f = z17;
            } catch (Exception e16) {
                QLog.e("NTLoginApp", 1, "updateWithAutoLoginSwitch, " + e16);
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (Arrays.equals(iVar.f431113a, this.f431113a) && iVar.f431114b == this.f431114b && iVar.f431115c == this.f431115c && Arrays.equals(iVar.f431116d, this.f431116d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        byte[] bArr = this.f431113a;
        int i3 = 0;
        if (bArr == null) {
            hashCode = 0;
        } else {
            hashCode = Arrays.hashCode(bArr);
        }
        int i16 = (((((527 + hashCode) * 31) + this.f431114b) * 31) + this.f431115c) * 31;
        byte[] bArr2 = this.f431116d;
        if (bArr2 != null) {
            i3 = Arrays.hashCode(bArr2);
        }
        return i16 + i3;
    }

    @NonNull
    public String toString() {
        String arrays;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("encryptGuid = ");
        byte[] bArr = this.f431113a;
        String str = "";
        if (bArr == null) {
            arrays = "";
        } else {
            arrays = Arrays.toString(bArr);
        }
        sb5.append(arrays);
        sb5.append(", encryptGuidVersion = ");
        sb5.append(this.f431114b);
        sb5.append(", loginSigAppId = ");
        sb5.append(this.f431115c);
        sb5.append(", appName = ");
        byte[] bArr2 = this.f431116d;
        if (bArr2 != null) {
            str = new String(bArr2);
        }
        sb5.append(str);
        sb5.append(", canAutoLogin = ");
        sb5.append(this.f431117e);
        sb5.append(", trusted = ");
        sb5.append(this.f431118f);
        return sb5.toString();
    }
}

package y53;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes21.dex */
public class g implements SharedPreferences.Editor {

    /* renamed from: d, reason: collision with root package name */
    private final SharedPreferences.Editor f449488d;

    /* renamed from: e, reason: collision with root package name */
    private final String f449489e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f449490f;

    public g(@NonNull SharedPreferences.Editor editor, @NonNull String str, boolean z16) {
        this.f449488d = editor;
        this.f449489e = str;
        this.f449490f = z16;
    }

    private SharedPreferences a() {
        return QMMKV.fromSpAdapter(com.tencent.mobileqq.wink.b.c(), this.f449489e, QMMKVFile.FILE_QCIRCLE);
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.f449488d.apply();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        return this.f449488d.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.f449488d.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z16) {
        if (!this.f449490f) {
            a().edit().putBoolean(str, z16).apply();
        }
        return this.f449488d.putBoolean(str, z16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f16) {
        if (!this.f449490f) {
            a().edit().putFloat(str, f16).apply();
        }
        return this.f449488d.putFloat(str, f16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i3) {
        if (!this.f449490f) {
            a().edit().putInt(str, i3).apply();
        }
        return this.f449488d.putInt(str, i3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j3) {
        if (!this.f449490f) {
            a().edit().putLong(str, j3).apply();
        }
        return this.f449488d.putLong(str, j3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        if (!this.f449490f) {
            a().edit().putString(str, str2).apply();
        }
        return this.f449488d.putString(str, str2);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        if (!this.f449490f) {
            a().edit().putStringSet(str, set).apply();
        }
        return this.f449488d.putStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        return this.f449488d.remove(str);
    }
}

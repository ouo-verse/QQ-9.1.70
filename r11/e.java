package r11;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e implements b {

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f430489h = new String[0];

    /* renamed from: a, reason: collision with root package name */
    private String f430490a;

    /* renamed from: b, reason: collision with root package name */
    private long f430491b;

    /* renamed from: c, reason: collision with root package name */
    private long f430492c;

    /* renamed from: d, reason: collision with root package name */
    private int f430493d = -1;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, Object> f430494e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private boolean f430495f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f430496g;

    private void d() {
        if (b()) {
        } else {
            throw new IllegalStateException("This session is invalid.");
        }
    }

    @Override // r11.b
    public boolean a() {
        d();
        return this.f430495f;
    }

    public boolean b() {
        if (!this.f430496g) {
            return false;
        }
        if (this.f430493d > 0) {
            if (((int) ((System.currentTimeMillis() - this.f430492c) / 1000)) >= this.f430493d) {
                this.f430496g = false;
            }
        } else {
            this.f430496g = true;
        }
        return this.f430496g;
    }

    public void c(boolean z16) {
        this.f430495f = z16;
    }

    public void e(@NonNull ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f430490a);
        objectOutputStream.writeLong(this.f430491b);
        objectOutputStream.writeLong(this.f430492c);
        objectOutputStream.writeInt(this.f430493d);
        objectOutputStream.writeBoolean(this.f430495f);
        objectOutputStream.writeBoolean(this.f430496g);
        objectOutputStream.writeInt(this.f430494e.size());
        for (String str : (String[]) this.f430494e.keySet().toArray(f430489h)) {
            Object obj = this.f430494e.get(str);
            if (obj != null && (obj instanceof Serializable)) {
                objectOutputStream.writeObject(str);
                objectOutputStream.writeObject(obj);
            }
        }
    }

    @Override // r11.b
    @NonNull
    public String getId() {
        return this.f430490a;
    }
}

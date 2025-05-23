package ro0;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import no0.k;
import qo0.e;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends c {

    /* renamed from: g, reason: collision with root package name */
    private final k f431772g;

    /* renamed from: h, reason: collision with root package name */
    private int f431773h;

    public a(@NonNull e eVar, k kVar) {
        super(eVar);
        this.f431772g = kVar;
    }

    @Override // ro0.c
    public int d(boolean z16, int i3, int i16) {
        if (z16) {
            return i16 - i3;
        }
        return this.f431772g.f420571a.f420605t;
    }

    public int h(int i3, int i16, int i17) {
        if (this.f431782a) {
            k.b bVar = this.f431772g.f420571a;
            float f16 = bVar.f420601p;
            this.f431773h = (int) Math.min(i3 - bVar.f420604s, Math.max(bVar.f420602q * f16, Math.min(r1 * i17, bVar.f420603r * f16)) + i16);
            if (QLog.isDevelopLevel()) {
                QLog.d("GuildAtPanelUIHelper", 4, "visualHeight: " + this.f431773h + " usableWindowHeight: " + i3 + " listViewTop: " + i16 + " itemCount: " + i17);
            }
            if (i3 != -1) {
                this.f431773h = Math.min(i3, this.f431773h);
            }
        }
        return this.f431773h;
    }

    public float i() {
        return this.f431783b.f429119i / 255.0f;
    }
}

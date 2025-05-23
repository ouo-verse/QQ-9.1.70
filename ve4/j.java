package ve4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tedger.outapi.api.IInitStateManager;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface j extends IInitStateManager {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {
        void a(@NonNull b bVar);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void a(int i3);

        void success();
    }

    void g(@NonNull a aVar, @Nullable IInitStateManager.a aVar2);
}

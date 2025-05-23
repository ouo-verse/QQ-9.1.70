package s2;

import android.content.Context;
import androidx.annotation.NonNull;
import com.hihonor.mcs.fitness.health.constants.DataType;
import com.hihonor.mcs.fitness.health.datastore.QueryRequest;
import com.hihonor.mcs.fitness.health.exception.HealthKitException;
import java.util.concurrent.ThreadPoolExecutor;
import o2.d;
import r2.a;
import w2.g;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b implements p2.a {

    /* renamed from: b, reason: collision with root package name */
    public static volatile b f433088b;

    /* renamed from: a, reason: collision with root package name */
    public Context f433089a;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements c<d> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y2.c f433090a;

        public a(b bVar, y2.c cVar) {
            this.f433090a = cVar;
        }

        @Override // s2.c
        public void a(int i3, p2.b<d> bVar) {
            this.f433090a.d(bVar, true);
        }

        @Override // s2.c
        public void onFail(int i3, String str) {
            this.f433090a.c(new HealthKitException(i3, str));
        }
    }

    public b(Context context) {
        if (context != null) {
            this.f433089a = context.getApplicationContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(y2.c cVar, QueryRequest queryRequest, o2.c cVar2) {
        a aVar = new a(this, cVar);
        if (queryRequest != null) {
            try {
                if (DataType.b(queryRequest.a()) == 1) {
                    Object obj = r2.a.f430555k;
                    a.c.f430567a.b(this.f433089a, cVar2, queryRequest, aVar);
                    return;
                }
            } catch (Exception e16) {
                cVar.c(e16);
                return;
            }
        }
        throw new HealthKitException(100002, "ILLEGAL_DATA_TYPE");
    }

    @Override // p2.a
    public y2.c<p2.b<d>> a(o2.c cVar, QueryRequest queryRequest) {
        return c(cVar, queryRequest);
    }

    @NonNull
    public final y2.c<p2.b<d>> c(final o2.c cVar, final QueryRequest queryRequest) {
        final g gVar = new g();
        try {
            ((ThreadPoolExecutor) w2.b.c()).execute(new Runnable() { // from class: s2.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.d(gVar, queryRequest, cVar);
                }
            });
        } catch (Exception e16) {
            gVar.c(e16);
        }
        return gVar;
    }
}

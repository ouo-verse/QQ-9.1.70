package v2;

import android.os.RemoteException;
import android.util.Log;
import com.hihonor.mcs.fitness.health.datastore.QueryRequest;
import com.hihonor.mcs.fitness.health.exception.HealthKitException;
import com.hihonor.mcs.fitness.health.internal.exception.IllegalDataException;
import com.hihonor.mcs.fitness.health.internal.exception.IllegalOperationException;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c implements b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f440777a = "DataManagerImpl";

    @Override // v2.b
    public void a(QueryRequest queryRequest, s2.c cVar) {
        if (cVar != null) {
            try {
                d.f440779e.d(queryRequest, cVar);
            } catch (RemoteException unused) {
                throw new HealthKitException(100013, "REMOTE_SERVICE_FAILED");
            } catch (IllegalDataException e16) {
                Log.e(f440777a, e16.getMessage());
                throw new HealthKitException(e16.a(), e16.getMessage());
            } catch (IllegalOperationException e17) {
                Log.e(f440777a, e17.getMessage());
                throw new HealthKitException(e17.a(), e17.getMessage());
            } catch (JSONException unused2) {
                Log.e(f440777a, "DATA_PARSE_FAILED");
                throw new HealthKitException(100001, "DATA_PARSE_FAILED");
            }
        }
    }
}

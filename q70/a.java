package q70;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleShoppingGoodsInfoBean;
import com.tencent.biz.qqcircle.requests.QCircleShoppingInfoGetRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetGoodsDetailRsp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends BaseViewModel {
    private String C;
    private String D;

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<QCircleShoppingGoodsInfoBean> f428455i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private FeedCloudMeta$StFeed f428456m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: q70.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C11061a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetGoodsDetailRsp> {
        C11061a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetGoodsDetailRsp feedCloudRead$StGetGoodsDetailRsp) {
            if (feedCloudRead$StGetGoodsDetailRsp != null && feedCloudRead$StGetGoodsDetailRsp.EGoodsRsp.get() != null) {
                a.this.C = feedCloudRead$StGetGoodsDetailRsp.EGoodsRsp.get();
                QLog.d("QFSShoppingGoodsViewModel", 1, "eGoodsRsp is " + a.this.C);
                a.this.N1().postValue(a.this.P1());
            }
        }
    }

    private String O1(String str) {
        if (Integer.parseInt(str) < 10000) {
            return str;
        }
        return new DecimalFormat("0.0").format(Double.parseDouble(str) / 10000.0d) + "\u4e07";
    }

    public MutableLiveData<QCircleShoppingGoodsInfoBean> N1() {
        return this.f428455i;
    }

    public QCircleShoppingGoodsInfoBean P1() {
        QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean = new QCircleShoppingGoodsInfoBean();
        try {
            JSONObject jSONObject = new JSONObject(this.C).getJSONArray("good_infos").getJSONObject(0);
            qCircleShoppingGoodsInfoBean.setId(jSONObject.getString("id"));
            qCircleShoppingGoodsInfoBean.setDesc(jSONObject.getString("name"));
            JSONArray jSONArray = jSONObject.getJSONObject("image").getJSONArray("detail_img_urls");
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.getString(i3));
            }
            qCircleShoppingGoodsInfoBean.setImageUrls(arrayList);
            qCircleShoppingGoodsInfoBean.setPrice(jSONObject.getJSONObject("price").getString("cur_price"));
            qCircleShoppingGoodsInfoBean.setJumpUrl(this.D);
            qCircleShoppingGoodsInfoBean.setSales("\u5df2\u552e" + O1(jSONObject.getString("sale_volume")) + "\u4ef6");
        } catch (Exception unused) {
            QLog.d("QFSShoppingGoodsViewModel", 1, "shopping cart json exception");
        }
        return qCircleShoppingGoodsInfoBean;
    }

    public void Q1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        this.f428456m = feedCloudMeta$StFeed;
        this.D = str;
        VSNetworkHelper.getInstance().sendRequest(new QCircleShoppingInfoGetRequest(this.f428456m), new C11061a());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSShoppingGoodsViewModel";
    }
}

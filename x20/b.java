package x20;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataConverter;
import qqcircle.QQCircleFeedBase$StMainPageBasicBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements IDataConverter<QQCircleFeedBase$StMainPageBasicBusiRspData> {
    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(QQCircleFeedBase$StMainPageBasicBusiRspData qQCircleFeedBase$StMainPageBasicBusiRspData) {
        return qQCircleFeedBase$StMainPageBasicBusiRspData.getClass().getName();
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(QQCircleFeedBase$StMainPageBasicBusiRspData qQCircleFeedBase$StMainPageBasicBusiRspData, QQCircleFeedBase$StMainPageBasicBusiRspData qQCircleFeedBase$StMainPageBasicBusiRspData2) {
        if (qQCircleFeedBase$StMainPageBasicBusiRspData != null && qQCircleFeedBase$StMainPageBasicBusiRspData2 != null) {
            try {
                qQCircleFeedBase$StMainPageBasicBusiRspData.mergeFrom(qQCircleFeedBase$StMainPageBasicBusiRspData2.toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QFSSettingDataConverter", 1, "mergeFrom StMainPageBusiRspData error. " + e16);
            }
        }
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QQCircleFeedBase$StMainPageBasicBusiRspData cloneConvertData(QQCircleFeedBase$StMainPageBasicBusiRspData qQCircleFeedBase$StMainPageBasicBusiRspData) {
        return qQCircleFeedBase$StMainPageBasicBusiRspData;
    }
}

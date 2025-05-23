package tencent.im.oidb.qfind;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.report.ReportConstant;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QFind$DeviceInfo extends MessageMicro<QFind$DeviceInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig;
    public QFind$DeviceLoc dev_loc;
    public final PBUInt64Field din;
    public QFind$HistoryData msg_walking_history;

    /* renamed from: sn, reason: collision with root package name */
    public final PBBytesField f436020sn;
    public final PBUInt32Field timestamp;
    public final PBUInt32Field type;
    public final PBUInt32Field uint32_need_verify_dev;
    public final PBUInt32Field uint32_verify_dev_interval;
    public final PBUInt64Field service_uuid = PBField.initUInt64(0);
    public final PBUInt32Field pid = PBField.initUInt32(0);

    static {
        String[] strArr = {"service_uuid", "pid", ReportConstant.COSTREPORT_SN, "din", "timestamp", "type", "dev_loc", "bytes_sig", "uint32_need_verify_dev", "uint32_verify_dev_interval", "msg_walking_history"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 58, 66, 72, 80, 162}, strArr, new Object[]{0L, 0, byteStringMicro, 0L, 0, 0, null, byteStringMicro, 0, 0, null}, QFind$DeviceInfo.class);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [tencent.im.oidb.qfind.QFind$HistoryData] */
    public QFind$DeviceInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.f436020sn = PBField.initBytes(byteStringMicro);
        this.din = PBField.initUInt64(0L);
        this.timestamp = PBField.initUInt32(0);
        this.type = PBField.initUInt32(0);
        this.dev_loc = new QFind$DeviceLoc();
        this.bytes_sig = PBField.initBytes(byteStringMicro);
        this.uint32_need_verify_dev = PBField.initUInt32(0);
        this.uint32_verify_dev_interval = PBField.initUInt32(0);
        this.msg_walking_history = new MessageMicro<QFind$HistoryData>() { // from class: tencent.im.oidb.qfind.QFind$HistoryData
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"details", "tag"}, new Object[]{null, 0}, QFind$HistoryData.class);
            public final PBRepeatMessageField<QFind$HistoryDetail> details = PBField.initRepeatMessage(QFind$HistoryDetail.class);
            public final PBUInt32Field tag = PBField.initUInt32(0);
        };
    }
}

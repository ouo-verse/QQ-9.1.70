package tencent.im.oidb.cmd0xcd5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcd5$ReqBody extends MessageMicro<oidb_cmd0xcd5$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"service_type", "getdata_req", "setdata_req", "check_req"}, new Object[]{0, null, null, null}, oidb_cmd0xcd5$ReqBody.class);
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    public oidb_cmd0xcd5$GetDataReq getdata_req = new oidb_cmd0xcd5$GetDataReq();
    public oidb_cmd0xcd5$SetDataReq setdata_req = new oidb_cmd0xcd5$SetDataReq();
    public oidb_cmd0xcd5$CheckReplyReq check_req = new MessageMicro<oidb_cmd0xcd5$CheckReplyReq>() { // from class: tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5$CheckReplyReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_cmd0xcd5$CheckReplyReq.class);
    };
}

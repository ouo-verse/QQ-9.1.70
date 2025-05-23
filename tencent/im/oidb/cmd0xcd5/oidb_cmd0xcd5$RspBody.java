package tencent.im.oidb.cmd0xcd5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcd5$RspBody extends MessageMicro<oidb_cmd0xcd5$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"servicetype", "getdata_rsp", "setdata_rsp", "check_rsp"}, new Object[]{0, null, null, null}, oidb_cmd0xcd5$RspBody.class);
    public final PBUInt32Field servicetype = PBField.initUInt32(0);
    public oidb_cmd0xcd5$GetDataRsp getdata_rsp = new oidb_cmd0xcd5$GetDataRsp();
    public oidb_cmd0xcd5$SetDataRsp setdata_rsp = new MessageMicro<oidb_cmd0xcd5$SetDataRsp>() { // from class: tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5$SetDataRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_cmd0xcd5$SetDataRsp.class);
    };
    public oidb_cmd0xcd5$CheckReplyRsp check_rsp = new MessageMicro<oidb_cmd0xcd5$CheckReplyRsp>() { // from class: tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5$CheckReplyRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"auto_reply_flag"}, new Object[]{0}, oidb_cmd0xcd5$CheckReplyRsp.class);
        public final PBUInt32Field auto_reply_flag = PBField.initUInt32(0);
    };
}

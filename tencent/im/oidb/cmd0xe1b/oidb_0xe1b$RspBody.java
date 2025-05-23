package tencent.im.oidb.cmd0xe1b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.kandian.flaginfo.flag_info$FlagInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe1b$RspBody extends MessageMicro<oidb_0xe1b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98}, new String[]{"msg_get_flag_info_rsp", "msg_set_flag_info_rsp"}, new Object[]{null, null}, oidb_0xe1b$RspBody.class);
    public oidb_0xe1b$GetFlagInfoRsp msg_get_flag_info_rsp = new MessageMicro<oidb_0xe1b$GetFlagInfoRsp>() { // from class: tencent.im.oidb.cmd0xe1b.oidb_0xe1b$GetFlagInfoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_flag_info_list"}, new Object[]{null}, oidb_0xe1b$GetFlagInfoRsp.class);
        public final PBRepeatMessageField<flag_info$FlagInfo> rpt_msg_flag_info_list = PBField.initRepeatMessage(flag_info$FlagInfo.class);
    };
    public oidb_0xe1b$SetFlagInfoRsp msg_set_flag_info_rsp = new MessageMicro<oidb_0xe1b$SetFlagInfoRsp>() { // from class: tencent.im.oidb.cmd0xe1b.oidb_0xe1b$SetFlagInfoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_flag_info_list"}, new Object[]{null}, oidb_0xe1b$SetFlagInfoRsp.class);
        public final PBRepeatMessageField<flag_info$FlagInfo> rpt_msg_flag_info_list = PBField.initRepeatMessage(flag_info$FlagInfo.class);
    };
}

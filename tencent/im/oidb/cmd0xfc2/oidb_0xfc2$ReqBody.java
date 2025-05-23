package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xfc2$ReqBody extends MessageMicro<oidb_0xfc2$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 34, 40, 802, 1602, 2402, 3202, 4002}, new String[]{"msg_cmd", "msg_bus_type", "msg_channel_info", "msg_terminal_type", "msg_apply_upload_req", "msg_upload_completed_req", "msg_apply_download_req", "msg_apply_preview_req", "msg_apply_security_strike_req"}, new Object[]{0, 0, null, 0, null, null, null, null, null}, oidb_0xfc2$ReqBody.class);
    public final PBEnumField msg_cmd = PBField.initEnum(0);
    public final PBEnumField msg_bus_type = PBField.initEnum(0);
    public oidb_0xfc2$ChannelInfo msg_channel_info = new oidb_0xfc2$ChannelInfo();
    public final PBEnumField msg_terminal_type = PBField.initEnum(0);
    public oidb_0xfc2$ApplyUploadReq msg_apply_upload_req = new oidb_0xfc2$ApplyUploadReq();
    public oidb_0xfc2$UploadCompletedReq msg_upload_completed_req = new oidb_0xfc2$UploadCompletedReq();
    public oidb_0xfc2$ApplyDownloadReq msg_apply_download_req = new oidb_0xfc2$ApplyDownloadReq();
    public oidb_0xfc2$ApplyPreviewReq msg_apply_preview_req = new MessageMicro<oidb_0xfc2$ApplyPreviewReq>() { // from class: tencent.im.oidb.cmd0xfc2.oidb_0xfc2$ApplyPreviewReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_fileid"}, new Object[]{""}, oidb_0xfc2$ApplyPreviewReq.class);
        public final PBStringField str_fileid = PBField.initString("");
    };
    public oidb_0xfc2$SecurityStrikeReq msg_apply_security_strike_req = new MessageMicro<oidb_0xfc2$SecurityStrikeReq>() { // from class: tencent.im.oidb.cmd0xfc2.oidb_0xfc2$SecurityStrikeReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"msg_cmd", "str_fileid", "uint64_seq", "msg_key"}, new Object[]{0, "", 0L, null}, oidb_0xfc2$SecurityStrikeReq.class);
        public final PBEnumField msg_cmd = PBField.initEnum(0);
        public final PBStringField str_fileid = PBField.initString("");
        public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
        public oidb_0xfc2$MsgKey msg_key = new MessageMicro<oidb_0xfc2$MsgKey>() { // from class: tencent.im.oidb.cmd0xfc2.oidb_0xfc2$MsgKey
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_random", "uint64_time"}, new Object[]{0L, 0L}, oidb_0xfc2$MsgKey.class);
            public final PBUInt64Field uint64_random = PBField.initUInt64(0);
            public final PBUInt64Field uint64_time = PBField.initUInt64(0);
        };
    };
}

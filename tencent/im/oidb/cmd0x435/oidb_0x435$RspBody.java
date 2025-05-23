package tencent.im.oidb.cmd0x435;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x435$RspBody extends MessageMicro<oidb_0x435$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg;
    public final PBBytesField bytes_topic_id;
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public oidb_0x435$AddTopicRspBody msg_add_rsp_body;
    public oidb_0x435$DeletePKItemRspBody msg_del_rsp_body;
    public oidb_0x435$GetAllPKItemsRspBody msg_get_all_pk_items_rsp_body;
    public oidb_0x435$GetPKItemRspBody msg_get_rsp_body;
    public oidb_0x435$AddVoteRspBody msg_vote_rsp_body;
    public final PBUInt32Field uint32_interval_time;
    public final PBUInt32Field uint32_subcmd;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 90, 98, 106, 114, 122}, new String[]{"int32_ret_code", "bytes_error_msg", "uint32_subcmd", "bytes_topic_id", "uint32_interval_time", "msg_add_rsp_body", "msg_vote_rsp_body", "msg_del_rsp_body", "msg_get_rsp_body", "msg_get_all_pk_items_rsp_body"}, new Object[]{0, byteStringMicro, 0, byteStringMicro, 0, null, null, null, null, null}, oidb_0x435$RspBody.class);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [tencent.im.oidb.cmd0x435.oidb_0x435$AddTopicRspBody] */
    /* JADX WARN: Type inference failed for: r0v3, types: [tencent.im.oidb.cmd0x435.oidb_0x435$AddVoteRspBody] */
    /* JADX WARN: Type inference failed for: r0v4, types: [tencent.im.oidb.cmd0x435.oidb_0x435$DeletePKItemRspBody] */
    /* JADX WARN: Type inference failed for: r0v5, types: [tencent.im.oidb.cmd0x435.oidb_0x435$GetPKItemRspBody] */
    /* JADX WARN: Type inference failed for: r0v6, types: [tencent.im.oidb.cmd0x435.oidb_0x435$GetAllPKItemsRspBody] */
    public oidb_0x435$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_error_msg = PBField.initBytes(byteStringMicro);
        this.uint32_subcmd = PBField.initUInt32(0);
        this.bytes_topic_id = PBField.initBytes(byteStringMicro);
        this.uint32_interval_time = PBField.initUInt32(0);
        this.msg_add_rsp_body = new MessageMicro<oidb_0x435$AddTopicRspBody>() { // from class: tencent.im.oidb.cmd0x435.oidb_0x435$AddTopicRspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_topic_info"}, new Object[]{null}, oidb_0x435$AddTopicRspBody.class);
            public oidb_0x435$TopicInfo msg_topic_info = new oidb_0x435$TopicInfo();
        };
        this.msg_vote_rsp_body = new MessageMicro<oidb_0x435$AddVoteRspBody>() { // from class: tencent.im.oidb.cmd0x435.oidb_0x435$AddVoteRspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0x435$AddVoteRspBody.class);
        };
        this.msg_del_rsp_body = new MessageMicro<oidb_0x435$DeletePKItemRspBody>() { // from class: tencent.im.oidb.cmd0x435.oidb_0x435$DeletePKItemRspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0x435$DeletePKItemRspBody.class);
        };
        this.msg_get_rsp_body = new MessageMicro<oidb_0x435$GetPKItemRspBody>() { // from class: tencent.im.oidb.cmd0x435.oidb_0x435$GetPKItemRspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_pk_item"}, new Object[]{null}, oidb_0x435$GetPKItemRspBody.class);
            public final PBRepeatMessageField<oidb_0x435$PKItem> rpt_msg_pk_item = PBField.initRepeatMessage(oidb_0x435$PKItem.class);
        };
        this.msg_get_all_pk_items_rsp_body = new MessageMicro<oidb_0x435$GetAllPKItemsRspBody>() { // from class: tencent.im.oidb.cmd0x435.oidb_0x435$GetAllPKItemsRspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_pk_item"}, new Object[]{null}, oidb_0x435$GetAllPKItemsRspBody.class);
            public final PBRepeatMessageField<oidb_0x435$PKItem> rpt_msg_pk_item = PBField.initRepeatMessage(oidb_0x435$PKItem.class);
        };
    }
}

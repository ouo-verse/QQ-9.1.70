package tencent.im.oidb.cmd0x435;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x435$ReqBody extends MessageMicro<oidb_0x435$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 90, 98, 106, 114, 122}, new String[]{"uint32_subcmd", "bytes_topic_id", "msg_add_req_body", "msg_vote_req_body", "msg_del_req_body", "msg_get_req_body", "msg_get_all_pk_items_req_body"}, new Object[]{0, ByteStringMicro.EMPTY, null, null, null, null, null}, oidb_0x435$ReqBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBBytesField bytes_topic_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x435$AddTopicReqBody msg_add_req_body = new MessageMicro<oidb_0x435$AddTopicReqBody>() { // from class: tencent.im.oidb.cmd0x435.oidb_0x435$AddTopicReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_topic_info"}, new Object[]{null}, oidb_0x435$AddTopicReqBody.class);
        public oidb_0x435$TopicInfo msg_topic_info = new oidb_0x435$TopicInfo();
    };
    public oidb_0x435$AddVoteReqBody msg_vote_req_body = new MessageMicro<oidb_0x435$AddVoteReqBody>() { // from class: tencent.im.oidb.cmd0x435.oidb_0x435$AddVoteReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_pk_item_id", "rpt_msg_vote_item"}, new Object[]{0, null}, oidb_0x435$AddVoteReqBody.class);
        public final PBUInt32Field uint32_pk_item_id = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_0x435$VoteItem> rpt_msg_vote_item = PBField.initRepeatMessage(oidb_0x435$VoteItem.class);
    };
    public oidb_0x435$DeletePKItemReqBody msg_del_req_body = new MessageMicro<oidb_0x435$DeletePKItemReqBody>() { // from class: tencent.im.oidb.cmd0x435.oidb_0x435$DeletePKItemReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_pk_item_id"}, new Object[]{0}, oidb_0x435$DeletePKItemReqBody.class);
        public final PBUInt32Field uint32_pk_item_id = PBField.initUInt32(0);
    };
    public oidb_0x435$GetPKItemReqBody msg_get_req_body = new MessageMicro<oidb_0x435$GetPKItemReqBody>() { // from class: tencent.im.oidb.cmd0x435.oidb_0x435$GetPKItemReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_pk_item_id"}, new Object[]{0}, oidb_0x435$GetPKItemReqBody.class);
        public final PBUInt32Field uint32_pk_item_id = PBField.initUInt32(0);
    };
    public oidb_0x435$GetAllPKItemsReqBody msg_get_all_pk_items_req_body = new MessageMicro<oidb_0x435$GetAllPKItemsReqBody>() { // from class: tencent.im.oidb.cmd0x435.oidb_0x435$GetAllPKItemsReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_pk_item_id"}, new Object[]{0}, oidb_0x435$GetAllPKItemsReqBody.class);
        public final PBUInt32Field uint32_pk_item_id = PBField.initUInt32(0);
    };
}

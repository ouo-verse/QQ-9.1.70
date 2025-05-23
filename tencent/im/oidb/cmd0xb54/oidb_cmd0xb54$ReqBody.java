package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb54$ReqBody extends MessageMicro<oidb_cmd0xb54$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"msg_client", "msg_req_article", "uint32_topic", "msg_option"}, new Object[]{null, null, 0, null}, oidb_cmd0xb54$ReqBody.class);
    public oidb_cmd0xb54$Client msg_client = new MessageMicro<oidb_cmd0xb54$Client>() { // from class: tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$Client
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_version", "uint32_type"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_cmd0xb54$Client.class);
        public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    };
    public oidb_cmd0xb54$ReqArticle msg_req_article = new MessageMicro<oidb_cmd0xb54$ReqArticle>() { // from class: tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$ReqArticle
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatField<ByteStringMicro> rpt_bytes_style_card_id = PBField.initRepeat(PBBytesField.__repeatHelper__);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_row_key", "rpt_bytes_style_card_id"}, new Object[]{byteStringMicro, byteStringMicro}, oidb_cmd0xb54$ReqArticle.class);
        }
    };
    public final PBUInt32Field uint32_topic = PBField.initUInt32(0);
    public oidb_cmd0xb54$ReqOption msg_option = new MessageMicro<oidb_cmd0xb54$ReqOption>() { // from class: tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$ReqOption
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88}, new String[]{"uint32_biu_count", "uint32_like_count", "uint32_is_like", "uint32_style_card", "uint32_related_search_size", "uint32_article_business", "uint32_related_search", "uint32_need_fusion_biu_info", "uint32_need_proteus_json_data", "uint32_need_coin", "uint32_need_share"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, oidb_cmd0xb54$ReqOption.class);
        public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_is_like = PBField.initUInt32(0);
        public final PBUInt32Field uint32_style_card = PBField.initUInt32(0);
        public final PBUInt32Field uint32_related_search_size = PBField.initUInt32(0);
        public final PBUInt32Field uint32_article_business = PBField.initUInt32(0);
        public final PBUInt32Field uint32_related_search = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_fusion_biu_info = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_proteus_json_data = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_coin = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_share = PBField.initUInt32(0);
    };
}

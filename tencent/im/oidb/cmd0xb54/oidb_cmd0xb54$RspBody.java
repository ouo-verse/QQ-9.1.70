package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xb74.cmd0xb74$FusionBiuInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb54$RspBody extends MessageMicro<oidb_cmd0xb54$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_allow_like;
    public final PBBytesField bytes_proteus_json_data;
    public final PBBytesField bytes_search_word_sid;
    public oidb_cmd0xb54$ArticleBusiness msg_article_business;
    public oidb_cmd0xb54$CoinInfo msg_coin_info;
    public cmd0xb74$FusionBiuInfo msg_fusion_biu_info;
    public oidb_cmd0xb54$ShareNumItem msg_share_num;
    public final PBUInt32Field uint32_forbidden_status;
    public oidb_cmd0xb54$RspTopic msg_rsp_topic = new MessageMicro<oidb_cmd0xb54$RspTopic>() { // from class: tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$RspTopic
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_topic"}, new Object[]{null}, oidb_cmd0xb54$RspTopic.class);
        public final PBRepeatMessageField<oidb_cmd0xb54$Topic> rpt_msg_topic = PBField.initRepeatMessage(oidb_cmd0xb54$Topic.class);
    };
    public oidb_cmd0xb54$RspBiuCount msg_rsp_biu_count = new MessageMicro<oidb_cmd0xb54$RspBiuCount>() { // from class: tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$RspBiuCount
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_biu_count"}, new Object[]{0L}, oidb_cmd0xb54$RspBiuCount.class);
        public final PBUInt64Field uint64_biu_count = PBField.initUInt64(0);
    };
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_like = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_cmd0xb54$StyleCard> rpt_msg_style_card = PBField.initRepeatMessage(oidb_cmd0xb54$StyleCard.class);
    public final PBRepeatMessageField<oidb_cmd0xb54$RelatedSearchWord> rpt_related_search_word = PBField.initRepeatMessage(oidb_cmd0xb54$RelatedSearchWord.class);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58, 66, 74, 82, 90, 98, 104, 8000}, new String[]{"msg_rsp_topic", "msg_rsp_biu_count", "uint32_like_count", "uint32_is_like", "rpt_msg_style_card", "rpt_related_search_word", "bytes_search_word_sid", "msg_article_business", "msg_fusion_biu_info", "bytes_proteus_json_data", "msg_coin_info", "msg_share_num", "uint32_forbidden_status", "bool_allow_like"}, new Object[]{null, null, 0, 0, null, null, byteStringMicro, null, null, byteStringMicro, null, null, 0, Boolean.TRUE}, oidb_cmd0xb54$RspBody.class);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$RspTopic] */
    /* JADX WARN: Type inference failed for: r0v1, types: [tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$RspBiuCount] */
    /* JADX WARN: Type inference failed for: r1v8, types: [tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$CoinInfo] */
    /* JADX WARN: Type inference failed for: r1v9, types: [tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$ShareNumItem] */
    /* JADX WARN: Type inference failed for: r2v1, types: [tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$ArticleBusiness] */
    public oidb_cmd0xb54$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_search_word_sid = PBField.initBytes(byteStringMicro);
        this.msg_article_business = new MessageMicro<oidb_cmd0xb54$ArticleBusiness>() { // from class: tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$ArticleBusiness
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 82, 90}, new String[]{"uint32_business_cash_flag", "bytes_business_cash_info", "msg_sentiment_entity_data", "msg_union_nlp_info"}, new Object[]{0, ByteStringMicro.EMPTY, null, null}, oidb_cmd0xb54$ArticleBusiness.class);
            public final PBUInt32Field uint32_business_cash_flag = PBField.initUInt32(0);
            public final PBBytesField bytes_business_cash_info = PBField.initBytes(ByteStringMicro.EMPTY);
            public oidb_cmd0xb54$SentimentEntityData msg_sentiment_entity_data = new MessageMicro<oidb_cmd0xb54$SentimentEntityData>() { // from class: tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$SentimentEntityData
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBBytesField bytes_data;
                public final PBBytesField bytes_relation;

                static {
                    ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_data", "bytes_relation"}, new Object[]{byteStringMicro2, byteStringMicro2}, oidb_cmd0xb54$SentimentEntityData.class);
                }

                {
                    ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                    this.bytes_data = PBField.initBytes(byteStringMicro2);
                    this.bytes_relation = PBField.initBytes(byteStringMicro2);
                }
            };
            public oidb_cmd0xb54$UnionNlpInfo msg_union_nlp_info = new MessageMicro<oidb_cmd0xb54$UnionNlpInfo>() { // from class: tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$UnionNlpInfo
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBBytesField bytes_union_chann;
                public final PBBytesField bytes_union_tag;

                static {
                    ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_union_tag", "bytes_union_chann"}, new Object[]{byteStringMicro2, byteStringMicro2}, oidb_cmd0xb54$UnionNlpInfo.class);
                }

                {
                    ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                    this.bytes_union_tag = PBField.initBytes(byteStringMicro2);
                    this.bytes_union_chann = PBField.initBytes(byteStringMicro2);
                }
            };
        };
        this.msg_fusion_biu_info = new cmd0xb74$FusionBiuInfo();
        this.bytes_proteus_json_data = PBField.initBytes(byteStringMicro);
        this.msg_coin_info = new MessageMicro<oidb_cmd0xb54$CoinInfo>() { // from class: tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$CoinInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{32, 40}, new String[]{"content_has_coin", "content_coin_num"}, new Object[]{Boolean.FALSE, 0}, oidb_cmd0xb54$CoinInfo.class);
            public final PBBoolField content_has_coin = PBField.initBool(false);
            public final PBInt32Field content_coin_num = PBField.initInt32(0);
        };
        this.msg_share_num = new MessageMicro<oidb_cmd0xb54$ShareNumItem>() { // from class: tencent.im.oidb.cmd0xb54.oidb_cmd0xb54$ShareNumItem
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_rowkey", "uint64_num"}, new Object[]{ByteStringMicro.EMPTY, 0L}, oidb_cmd0xb54$ShareNumItem.class);
            public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt64Field uint64_num = PBField.initUInt64(0);
        };
        this.uint32_forbidden_status = PBField.initUInt32(0);
        this.bool_allow_like = PBField.initBool(true);
    }
}

package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x8c8$FeedsInfo extends MessageMicro<oidb_cmd0x8c8$FeedsInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_cmd0x8c8$AccountInfo account_info;
    public final PBBytesField bytes_article_summary;
    public final PBBytesField bytes_business_name;
    public final PBBytesField bytes_business_name_prefix;
    public final PBBytesField bytes_business_url;
    public final PBBytesField bytes_number_of_participants;
    public final PBBytesField bytes_rowkey;
    public final PBBytesField bytes_subscribe_id;
    public final PBBytesField bytes_subscribe_name;
    public final PBBytesField json_video_list;
    public oidb_cmd0x8c8$SocializeFeedsInfo msg_social_fees_info;
    public final PBUInt32Field uint32_business_id;
    public final PBEnumField feeds_type = PBField.initEnum(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_article_is_video = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64, 74, 82, 90, 98, 106, 114, 4002}, new String[]{"feeds_type", "uint64_article_id", "uint32_article_is_video", "bytes_subscribe_name", "json_video_list", "bytes_subscribe_id", "bytes_article_summary", "uint32_business_id", "bytes_business_name", "bytes_business_url", "msg_social_fees_info", "bytes_business_name_prefix", "account_info", "bytes_rowkey", "bytes_number_of_participants"}, new Object[]{0, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, null, byteStringMicro, null, byteStringMicro, byteStringMicro}, oidb_cmd0x8c8$FeedsInfo.class);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$SocializeFeedsInfo] */
    /* JADX WARN: Type inference failed for: r0v7, types: [tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$AccountInfo] */
    public oidb_cmd0x8c8$FeedsInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_subscribe_name = PBField.initBytes(byteStringMicro);
        this.json_video_list = PBField.initBytes(byteStringMicro);
        this.bytes_subscribe_id = PBField.initBytes(byteStringMicro);
        this.bytes_article_summary = PBField.initBytes(byteStringMicro);
        this.uint32_business_id = PBField.initUInt32(0);
        this.bytes_business_name = PBField.initBytes(byteStringMicro);
        this.bytes_business_url = PBField.initBytes(byteStringMicro);
        this.bytes_number_of_participants = PBField.initBytes(byteStringMicro);
        this.msg_social_fees_info = new MessageMicro<oidb_cmd0x8c8$SocializeFeedsInfo>() { // from class: tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$SocializeFeedsInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_comments;
            public final PBBytesField bytes_recommend_reason;
            public oidb_cmd0x8c8$BiuMultiLevel msg_biu_mutli_level;
            public oidb_cmd0x8c8$PGCFeedsInfo msg_pgc_topic_feeds_info;
            public oidb_cmd0x8c8$SocializeFeedsExtInfo msg_socialize_feeds_ext_info;
            public oidb_cmd0x8c8$TopicRecommendFeedsInfo msg_topic_recommend_feeds_info;
            public oidb_cmd0x8c8$UGCFeedsInfo msg_ugc_topic_feeds_info;
            public oidb_cmd0x8c8$VerifyResult msg_verify_result;
            public final PBUInt32Field uint32_biu_count;
            public final PBUInt32Field uint32_biu_time;
            public final PBUInt32Field uint32_comments_count;
            public final PBUInt32Field uint32_follow_count;
            public final PBUInt32Field uint32_follow_status;
            public final PBUInt32Field uint32_like_count;
            public final PBUInt32Field uint32_myself_biu_status;
            public final PBUInt32Field uint32_myself_like_status;
            public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);
            public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
            public final PBUInt64Field uint64_article_id = PBField.initUInt64(0);
            public oidb_cmd0x8c8$SocializeFeedsInfoUser msg_master_uin = new MessageMicro<oidb_cmd0x8c8$SocializeFeedsInfoUser>() { // from class: tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$SocializeFeedsInfoUser
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "enum_uin_type"}, new Object[]{0L, 0}, oidb_cmd0x8c8$SocializeFeedsInfoUser.class);
                public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
                public final PBEnumField enum_uin_type = PBField.initEnum(0);
            };
            public final PBRepeatMessageField<oidb_cmd0x8c8$SocializeFeedsInfoUser> rpt_recommend_list = PBField.initRepeatMessage(oidb_cmd0x8c8$SocializeFeedsInfoUser.class);

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 90, 98, 106, 114, 120, 128, 136, 146, 152, 160, 168, 178, 186, 194, 202, 210, 216, 224}, new String[]{"uint64_feeds_id", "uint32_feeds_style", "uint64_article_id", "msg_master_uin", "rpt_recommend_list", "bytes_comments", "bytes_recommend_reason", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "msg_socialize_feeds_ext_info", "uint32_biu_time", "uint32_myself_biu_status", "uint32_biu_count", "msg_biu_mutli_level", "msg_ugc_topic_feeds_info", "msg_pgc_topic_feeds_info", "msg_verify_result", "msg_topic_recommend_feeds_info", "uint32_follow_status", "uint32_follow_count"}, new Object[]{0L, 0, 0L, null, null, byteStringMicro2, byteStringMicro2, 0, 0, 0, null, 0, 0, 0, null, null, null, null, null, 0, 0}, oidb_cmd0x8c8$SocializeFeedsInfo.class);
            }

            /* JADX WARN: Type inference failed for: r0v10, types: [tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$SocializeFeedsExtInfo] */
            /* JADX WARN: Type inference failed for: r0v14, types: [tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$BiuMultiLevel] */
            /* JADX WARN: Type inference failed for: r0v15, types: [tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$UGCFeedsInfo] */
            /* JADX WARN: Type inference failed for: r0v16, types: [tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$PGCFeedsInfo] */
            /* JADX WARN: Type inference failed for: r0v17, types: [tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$VerifyResult] */
            /* JADX WARN: Type inference failed for: r0v18, types: [tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$TopicRecommendFeedsInfo] */
            /* JADX WARN: Type inference failed for: r0v2, types: [tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$SocializeFeedsInfoUser] */
            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_comments = PBField.initBytes(byteStringMicro2);
                this.bytes_recommend_reason = PBField.initBytes(byteStringMicro2);
                this.uint32_like_count = PBField.initUInt32(0);
                this.uint32_myself_like_status = PBField.initUInt32(0);
                this.uint32_comments_count = PBField.initUInt32(0);
                this.msg_socialize_feeds_ext_info = new MessageMicro<oidb_cmd0x8c8$SocializeFeedsExtInfo>() { // from class: tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$SocializeFeedsExtInfo
                    static final MessageMicro.FieldMap __fieldMap__;
                    public final PBBytesField bytes_article_url;
                    public final PBBytesField bytes_site_name;
                    public final PBBytesField bytes_subject;
                    public final PBBytesField bytes_sum_pic_url;
                    public final PBUInt32Field uint32_publish_time = PBField.initUInt32(0);
                    public final PBUInt32Field uint32_source = PBField.initUInt32(0);

                    static {
                        ByteStringMicro byteStringMicro3 = ByteStringMicro.EMPTY;
                        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50}, new String[]{"uint32_publish_time", "uint32_source", "bytes_article_url", "bytes_subject", "bytes_sum_pic_url", "bytes_site_name"}, new Object[]{0, 0, byteStringMicro3, byteStringMicro3, byteStringMicro3, byteStringMicro3}, oidb_cmd0x8c8$SocializeFeedsExtInfo.class);
                    }

                    {
                        ByteStringMicro byteStringMicro3 = ByteStringMicro.EMPTY;
                        this.bytes_article_url = PBField.initBytes(byteStringMicro3);
                        this.bytes_subject = PBField.initBytes(byteStringMicro3);
                        this.bytes_sum_pic_url = PBField.initBytes(byteStringMicro3);
                        this.bytes_site_name = PBField.initBytes(byteStringMicro3);
                    }
                };
                this.uint32_biu_time = PBField.initUInt32(0);
                this.uint32_myself_biu_status = PBField.initUInt32(0);
                this.uint32_biu_count = PBField.initUInt32(0);
                this.msg_biu_mutli_level = new MessageMicro<oidb_cmd0x8c8$BiuMultiLevel>() { // from class: tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$BiuMultiLevel
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"rpt_biu_mutli_level", "uint64_origin_feeds_id", "uint64_origin_feeds_type", "enum_origin_verify_status"}, new Object[]{null, 0L, 0L, 2}, oidb_cmd0x8c8$BiuMultiLevel.class);
                    public final PBRepeatMessageField<oidb_cmd0x8c8$BiuOneLevelItem> rpt_biu_mutli_level = PBField.initRepeatMessage(oidb_cmd0x8c8$BiuOneLevelItem.class);
                    public final PBUInt64Field uint64_origin_feeds_id = PBField.initUInt64(0);
                    public final PBUInt64Field uint64_origin_feeds_type = PBField.initUInt64(0);
                    public final PBEnumField enum_origin_verify_status = PBField.initEnum(2);
                };
                this.msg_ugc_topic_feeds_info = new MessageMicro<oidb_cmd0x8c8$UGCFeedsInfo>() { // from class: tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$UGCFeedsInfo
                    static final MessageMicro.FieldMap __fieldMap__;
                    public final PBBytesField bytes_json_content;
                    public final PBBytesField bytes_json_pic_list;
                    public final PBBytesField bytes_json_video_list;
                    public final PBBytesField bytes_ugc_comments;
                    public final PBEnumField enum_ugc_feeds_card_type = PBField.initEnum(0);
                    public final PBUInt64Field uint64_cuin = PBField.initUInt64(0);
                    public final PBRepeatMessageField<oidb_cmd0x8c8$UGCPicInfo> msg_ugc_pic_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8$UGCPicInfo.class);
                    public final PBRepeatMessageField<oidb_cmd0x8c8$UGCVideoInfo> msg_ugc_video_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8$UGCVideoInfo.class);

                    static {
                        ByteStringMicro byteStringMicro3 = ByteStringMicro.EMPTY;
                        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 90, 98, 106, 114, 122, 130}, new String[]{"enum_ugc_feeds_card_type", "uint64_cuin", "msg_ugc_pic_info_list", "msg_ugc_video_info_list", "bytes_ugc_comments", "bytes_json_pic_list", "bytes_json_video_list", "bytes_json_content"}, new Object[]{0, 0L, null, null, byteStringMicro3, byteStringMicro3, byteStringMicro3, byteStringMicro3}, oidb_cmd0x8c8$UGCFeedsInfo.class);
                    }

                    {
                        ByteStringMicro byteStringMicro3 = ByteStringMicro.EMPTY;
                        this.bytes_ugc_comments = PBField.initBytes(byteStringMicro3);
                        this.bytes_json_pic_list = PBField.initBytes(byteStringMicro3);
                        this.bytes_json_video_list = PBField.initBytes(byteStringMicro3);
                        this.bytes_json_content = PBField.initBytes(byteStringMicro3);
                    }
                };
                this.msg_pgc_topic_feeds_info = new MessageMicro<oidb_cmd0x8c8$PGCFeedsInfo>() { // from class: tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$PGCFeedsInfo
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 90, 98, 106, 112, 120}, new String[]{"enum_pgc_feeds_card_type", "uint64_puin", "msg_pgc_pic_info_list", "msg_pgc_video_info_list", "bytes_pgc_comments", "uint32_myself_follow_status", "uint32_follow_counts"}, new Object[]{0, 0L, null, null, ByteStringMicro.EMPTY, 0, 0}, oidb_cmd0x8c8$PGCFeedsInfo.class);
                    public final PBEnumField enum_pgc_feeds_card_type = PBField.initEnum(0);
                    public final PBUInt64Field uint64_puin = PBField.initUInt64(0);
                    public final PBRepeatMessageField<oidb_cmd0x8c8$PGCPicInfo> msg_pgc_pic_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8$PGCPicInfo.class);
                    public final PBRepeatMessageField<oidb_cmd0x8c8$PGCVideoInfo> msg_pgc_video_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8$PGCVideoInfo.class);
                    public final PBBytesField bytes_pgc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
                    public final PBUInt32Field uint32_myself_follow_status = PBField.initUInt32(0);
                    public final PBUInt32Field uint32_follow_counts = PBField.initUInt32(0);
                };
                this.msg_verify_result = new MessageMicro<oidb_cmd0x8c8$VerifyResult>() { // from class: tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$VerifyResult
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"enum_verify_status", "bytes_reason"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_cmd0x8c8$VerifyResult.class);
                    public final PBEnumField enum_verify_status = PBField.initEnum(0);
                    public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
                };
                this.msg_topic_recommend_feeds_info = new MessageMicro<oidb_cmd0x8c8$TopicRecommendFeedsInfo>() { // from class: tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$TopicRecommendFeedsInfo
                    static final MessageMicro.FieldMap __fieldMap__;
                    public final PBBytesField bytes_comments;
                    public final PBBytesField bytes_subscribe_id;
                    public oidb_cmd0x8c8$TopicRecommendFeedsTitle msg_left_title;
                    public oidb_cmd0x8c8$TopicRecommendFeedsTitle msg_right_title;
                    public final PBRepeatMessageField<oidb_cmd0x8c8$TopicRecommendInfo> msg_topic_recommend_info;
                    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);
                    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
                    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

                    static {
                        ByteStringMicro byteStringMicro3 = ByteStringMicro.EMPTY;
                        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 90, 98, 106, 114}, new String[]{"uint64_feeds_id", "uint32_feeds_style", "uint64_uin", "bytes_subscribe_id", "msg_topic_recommend_info", "msg_left_title", "msg_right_title", "bytes_comments"}, new Object[]{0L, 0, 0L, byteStringMicro3, null, null, null, byteStringMicro3}, oidb_cmd0x8c8$TopicRecommendFeedsInfo.class);
                    }

                    /* JADX WARN: Type inference failed for: r1v3, types: [tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$TopicRecommendFeedsTitle] */
                    /* JADX WARN: Type inference failed for: r1v4, types: [tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$TopicRecommendFeedsTitle] */
                    {
                        ByteStringMicro byteStringMicro3 = ByteStringMicro.EMPTY;
                        this.bytes_subscribe_id = PBField.initBytes(byteStringMicro3);
                        this.msg_topic_recommend_info = PBField.initRepeatMessage(oidb_cmd0x8c8$TopicRecommendInfo.class);
                        this.msg_left_title = new MessageMicro<oidb_cmd0x8c8$TopicRecommendFeedsTitle>() { // from class: tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$TopicRecommendFeedsTitle
                            static final MessageMicro.FieldMap __fieldMap__;
                            public final PBBytesField bytes_title_content;
                            public final PBBytesField bytes_url;

                            static {
                                ByteStringMicro byteStringMicro4 = ByteStringMicro.EMPTY;
                                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_title_content", "bytes_url"}, new Object[]{byteStringMicro4, byteStringMicro4}, oidb_cmd0x8c8$TopicRecommendFeedsTitle.class);
                            }

                            {
                                ByteStringMicro byteStringMicro4 = ByteStringMicro.EMPTY;
                                this.bytes_title_content = PBField.initBytes(byteStringMicro4);
                                this.bytes_url = PBField.initBytes(byteStringMicro4);
                            }
                        };
                        this.msg_right_title = new MessageMicro<oidb_cmd0x8c8$TopicRecommendFeedsTitle>() { // from class: tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$TopicRecommendFeedsTitle
                            static final MessageMicro.FieldMap __fieldMap__;
                            public final PBBytesField bytes_title_content;
                            public final PBBytesField bytes_url;

                            static {
                                ByteStringMicro byteStringMicro4 = ByteStringMicro.EMPTY;
                                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_title_content", "bytes_url"}, new Object[]{byteStringMicro4, byteStringMicro4}, oidb_cmd0x8c8$TopicRecommendFeedsTitle.class);
                            }

                            {
                                ByteStringMicro byteStringMicro4 = ByteStringMicro.EMPTY;
                                this.bytes_title_content = PBField.initBytes(byteStringMicro4);
                                this.bytes_url = PBField.initBytes(byteStringMicro4);
                            }
                        };
                        this.bytes_comments = PBField.initBytes(byteStringMicro3);
                    }
                };
                this.uint32_follow_status = PBField.initUInt32(0);
                this.uint32_follow_count = PBField.initUInt32(0);
            }
        };
        this.bytes_business_name_prefix = PBField.initBytes(byteStringMicro);
        this.account_info = new MessageMicro<oidb_cmd0x8c8$AccountInfo>() { // from class: tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$AccountInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_account_id", "uint32_is_account_approved", "uint32_is_account_derelict"}, new Object[]{0L, 0, 0}, oidb_cmd0x8c8$AccountInfo.class);
            public final PBUInt64Field uint64_account_id = PBField.initUInt64(0);
            public final PBUInt32Field uint32_is_account_approved = PBField.initUInt32(0);
            public final PBUInt32Field uint32_is_account_derelict = PBField.initUInt32(0);
        };
        this.bytes_rowkey = PBField.initBytes(byteStringMicro);
    }
}

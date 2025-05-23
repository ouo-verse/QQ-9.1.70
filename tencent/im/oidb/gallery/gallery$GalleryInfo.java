package tencent.im.oidb.gallery;

import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import tencent.im.oidb.gallery.dislike.dislikeInfo$DisLikeInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class gallery$GalleryInfo extends MessageMicro<gallery$GalleryInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_is_show_damping;
    public final PBBoolField bool_show_web_conf;
    public final PBBytesField bytes_ad_cookie;
    public final PBBytesField bytes_comments_url;
    public final PBBytesField bytes_common_desc;
    public final PBBytesField bytes_cookies;
    public final PBBytesField bytes_debug;
    public final PBBytesField bytes_from_url;
    public final PBBytesField bytes_gallery_url;
    public final PBBytesField bytes_pid;
    public final PBBytesField bytes_pos_ad_info;
    public final PBBytesField bytes_publisher_head_url;
    public final PBBytesField bytes_publisher_name;
    public final PBBytesField bytes_publisher_openid;
    public final PBBytesField bytes_reason;
    public final PBBytesField bytes_report_exdata;
    public final PBBytesField bytes_row_key;
    public final PBBytesField bytes_source_url;
    public final PBBytesField bytes_subject;
    public final PBBytesField bytes_summary_pic_url;
    public gallery$TComicInfo comic_info;
    public final PBUInt64Field feeds_id;
    public final PBDoubleField final_score;
    public final PBUInt32Field first_pic_height;
    public final PBUInt32Field first_pic_width;
    public final PBInt32Field int32_bid;
    public final PBInt32Field int32_info_type;
    public final PBInt32Field int32_pic_desc;
    public final PBInt32Field int32_reason;
    public final PBStringField kuaibao_jump_app_url;
    public final PBStringField kuaibao_jump_url;
    public gallery$PictureInfo msg_big_summary_pic;
    public gallery$ClassInfo msg_class_info;
    public gallery$PictureInfo msg_sig_summary_pic;
    public final PBRepeatMessageField<gallery$PictureInfo> msg_three_summary_pic;
    public final PBDoubleField quality_mean_score;
    public final PBDoubleField read_end_rate;
    public final PBDoubleField read_to_next_rate;
    public final PBDoubleField read_wilson_score;
    public final PBDoubleField recall_score;
    public final PBRepeatMessageField<dislikeInfo$DisLikeInfo> rpt_dislike_list;
    public final PBRepeatMessageField<gallery$ExtTag> rpt_ext_tag;
    public final PBRepeatMessageField<gallery$PictureInfo> rpt_msg_pic_info;
    public final PBRepeatMessageField<gallery$PictureInfo> rpt_msg_summary_pic;
    public final PBRepeatMessageField<gallery$TagInfo> rpt_msg_tag_info;
    public final PBStringField seq_id;
    public gallery$SocialInfo social_info;
    public final PBStringField str_icon_url;
    public final PBStringField str_name;
    public final PBStringField str_web_conf_id;
    public final PBStringField str_web_url;
    public final PBUInt32Field uint32_end_flag;
    public final PBUInt32Field uint32_is_account_derelict;
    public final PBUInt32Field uint32_is_attention_puin;
    public final PBUInt64Field uint64_article_id;
    public final PBUInt64Field uint64_create_time;
    public final PBUInt64Field uint64_display_type;
    public final PBUInt64Field uint64_pic_count;
    public final PBUInt64Field uint64_publisher_uin;
    public final PBUInt64Field uint64_source;
    public final PBUInt64Field uint64_source_article_id;
    public final PBUInt64Field uint64_sub_source;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50, 58, 66, 72, 80, 88, 96, 106, 114, 120, 128, 136, 144, 154, 162, 170, 242, 250, 258, 266, 274, 394, 402, 410, 416, PlayUI.UIType.BIG_CARD_SHAPED_PIC, 434, 482, 488, w.CTRL_INDEX, 504, 512, 522, 530, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_DETECTED_MULTI_NETWORK_CARD_AND_LOW_SPEED, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_QUICK_PLAY_WITH_OFFLINE_RESOURCE, PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA, PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT, 578, 584, 594, 602, 610, 618, 626, 8002, 8009, MessageHandlerConstants.NOTIFY_TYPE_REQ_INSERT_BLACKLIST_PB, 8026, MessageHandlerConstants.NOTIFY_TYPE_MAC_ONLINES_STATUS, MessageHandlerConstants.NOTIFY_TYPE_MATCH_CAMPUS_CHAT_ERROR_RSP, MessageHandlerConstants.NOTIFY_TYPE_MATCH_FRIEND_CHAT_ERROR_RSP, 8057, 8064, 8072, 16010}, new String[]{"bytes_row_key", "uint64_article_id", "bytes_publisher_openid", "uint64_publisher_uin", "bytes_publisher_name", "bytes_subject", "bytes_summary_pic_url", "rpt_msg_summary_pic", "uint64_source", "uint64_sub_source", "uint64_create_time", "uint64_pic_count", "rpt_msg_pic_info", "bytes_report_exdata", "uint64_display_type", "uint64_source_article_id", "int32_pic_desc", "int32_bid", "bytes_pid", "bytes_from_url", "rpt_ext_tag", "msg_class_info", "rpt_msg_tag_info", "msg_big_summary_pic", "msg_sig_summary_pic", "msg_three_summary_pic", "bytes_source_url", "bytes_gallery_url", "bytes_comments_url", "int32_reason", "bytes_reason", "rpt_dislike_list", "bytes_cookies", "uint32_end_flag", "uint32_is_account_derelict", "uint32_is_attention_puin", "bool_show_web_conf", "str_web_url", "str_icon_url", "str_name", "bool_is_show_damping", "str_web_conf_id", "int32_info_type", "kuaibao_jump_url", "kuaibao_jump_app_url", "feeds_id", "comic_info", "bytes_publisher_head_url", "bytes_common_desc", "bytes_pos_ad_info", "bytes_ad_cookie", "bytes_debug", "recall_score", "final_score", "seq_id", "read_to_next_rate", "read_end_rate", "read_wilson_score", "quality_mean_score", "first_pic_width", "first_pic_height", "social_info"}, new Object[]{byteStringMicro, 0L, byteStringMicro, 0L, byteStringMicro, byteStringMicro, byteStringMicro, null, 0L, 0L, 0L, 0L, null, byteStringMicro, 0L, 0L, 0, 0, byteStringMicro, byteStringMicro, null, null, null, null, null, null, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, null, byteStringMicro, 0, 0, 0, bool, "", "", "", bool, "", 0, "", "", 0L, null, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, valueOf, valueOf, "", valueOf, valueOf, valueOf, valueOf, 0, 0, null}, gallery$GalleryInfo.class);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [tencent.im.oidb.gallery.gallery$SocialInfo] */
    /* JADX WARN: Type inference failed for: r1v3, types: [tencent.im.oidb.gallery.gallery$TComicInfo] */
    /* JADX WARN: Type inference failed for: r5v10, types: [tencent.im.oidb.gallery.gallery$PictureInfo] */
    /* JADX WARN: Type inference failed for: r5v6, types: [tencent.im.oidb.gallery.gallery$ClassInfo] */
    /* JADX WARN: Type inference failed for: r5v9, types: [tencent.im.oidb.gallery.gallery$PictureInfo] */
    public gallery$GalleryInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_row_key = PBField.initBytes(byteStringMicro);
        this.uint64_article_id = PBField.initUInt64(0L);
        this.bytes_publisher_openid = PBField.initBytes(byteStringMicro);
        this.uint64_publisher_uin = PBField.initUInt64(0L);
        this.bytes_publisher_name = PBField.initBytes(byteStringMicro);
        this.bytes_subject = PBField.initBytes(byteStringMicro);
        this.bytes_summary_pic_url = PBField.initBytes(byteStringMicro);
        this.rpt_msg_summary_pic = PBField.initRepeatMessage(gallery$PictureInfo.class);
        this.uint64_source = PBField.initUInt64(0L);
        this.uint64_sub_source = PBField.initUInt64(0L);
        this.uint64_create_time = PBField.initUInt64(0L);
        this.uint64_pic_count = PBField.initUInt64(0L);
        this.rpt_msg_pic_info = PBField.initRepeatMessage(gallery$PictureInfo.class);
        this.bytes_report_exdata = PBField.initBytes(byteStringMicro);
        this.uint64_display_type = PBField.initUInt64(0L);
        this.uint64_source_article_id = PBField.initUInt64(0L);
        this.int32_pic_desc = PBField.initInt32(0);
        this.int32_bid = PBField.initInt32(0);
        this.bytes_pid = PBField.initBytes(byteStringMicro);
        this.bytes_from_url = PBField.initBytes(byteStringMicro);
        this.rpt_ext_tag = PBField.initRepeatMessage(gallery$ExtTag.class);
        this.msg_class_info = new MessageMicro<gallery$ClassInfo>() { // from class: tencent.im.oidb.gallery.gallery$ClassInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField Bytes_channel;
            public final PBBytesField Bytes_second_channel;
            public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0);
            public final PBUInt64Field uint64_second_channel_id;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uint64_channel_id", "Bytes_channel", "uint64_second_channel_id", "Bytes_second_channel"}, new Object[]{0L, byteStringMicro2, 0L, byteStringMicro2}, gallery$ClassInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.Bytes_channel = PBField.initBytes(byteStringMicro2);
                this.uint64_second_channel_id = PBField.initUInt64(0L);
                this.Bytes_second_channel = PBField.initBytes(byteStringMicro2);
            }
        };
        this.rpt_msg_tag_info = PBField.initRepeatMessage(gallery$TagInfo.class);
        this.msg_big_summary_pic = new MessageMicro<gallery$PictureInfo>() { // from class: tencent.im.oidb.gallery.gallery$PictureInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_cut_pic_url;
            public final PBBytesField bytes_pic_desc;
            public final PBBytesField bytes_pic_url;
            public final PBUInt64Field uint64_cut_height;
            public final PBUInt64Field uint64_cut_width;
            public final PBUInt64Field uint64_height;
            public final PBUInt64Field uint64_index;
            public final PBUInt64Field uint64_width;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 56, 64}, new String[]{"bytes_pic_url", "bytes_pic_desc", "uint64_index", "uint64_width", "uint64_height", "bytes_cut_pic_url", "uint64_cut_width", "uint64_cut_height"}, new Object[]{byteStringMicro2, byteStringMicro2, 0L, 0L, 0L, byteStringMicro2, 0L, 0L}, gallery$PictureInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_pic_url = PBField.initBytes(byteStringMicro2);
                this.bytes_pic_desc = PBField.initBytes(byteStringMicro2);
                this.uint64_index = PBField.initUInt64(0L);
                this.uint64_width = PBField.initUInt64(0L);
                this.uint64_height = PBField.initUInt64(0L);
                this.bytes_cut_pic_url = PBField.initBytes(byteStringMicro2);
                this.uint64_cut_width = PBField.initUInt64(0L);
                this.uint64_cut_height = PBField.initUInt64(0L);
            }
        };
        this.msg_sig_summary_pic = new MessageMicro<gallery$PictureInfo>() { // from class: tencent.im.oidb.gallery.gallery$PictureInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_cut_pic_url;
            public final PBBytesField bytes_pic_desc;
            public final PBBytesField bytes_pic_url;
            public final PBUInt64Field uint64_cut_height;
            public final PBUInt64Field uint64_cut_width;
            public final PBUInt64Field uint64_height;
            public final PBUInt64Field uint64_index;
            public final PBUInt64Field uint64_width;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 56, 64}, new String[]{"bytes_pic_url", "bytes_pic_desc", "uint64_index", "uint64_width", "uint64_height", "bytes_cut_pic_url", "uint64_cut_width", "uint64_cut_height"}, new Object[]{byteStringMicro2, byteStringMicro2, 0L, 0L, 0L, byteStringMicro2, 0L, 0L}, gallery$PictureInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_pic_url = PBField.initBytes(byteStringMicro2);
                this.bytes_pic_desc = PBField.initBytes(byteStringMicro2);
                this.uint64_index = PBField.initUInt64(0L);
                this.uint64_width = PBField.initUInt64(0L);
                this.uint64_height = PBField.initUInt64(0L);
                this.bytes_cut_pic_url = PBField.initBytes(byteStringMicro2);
                this.uint64_cut_width = PBField.initUInt64(0L);
                this.uint64_cut_height = PBField.initUInt64(0L);
            }
        };
        this.msg_three_summary_pic = PBField.initRepeatMessage(gallery$PictureInfo.class);
        this.bytes_source_url = PBField.initBytes(byteStringMicro);
        this.bytes_gallery_url = PBField.initBytes(byteStringMicro);
        this.bytes_comments_url = PBField.initBytes(byteStringMicro);
        this.int32_reason = PBField.initInt32(0);
        this.bytes_reason = PBField.initBytes(byteStringMicro);
        this.rpt_dislike_list = PBField.initRepeatMessage(dislikeInfo$DisLikeInfo.class);
        this.bytes_cookies = PBField.initBytes(byteStringMicro);
        this.uint32_end_flag = PBField.initUInt32(0);
        this.uint32_is_account_derelict = PBField.initUInt32(0);
        this.uint32_is_attention_puin = PBField.initUInt32(0);
        this.bool_show_web_conf = PBField.initBool(false);
        this.str_web_url = PBField.initString("");
        this.str_icon_url = PBField.initString("");
        this.str_name = PBField.initString("");
        this.bool_is_show_damping = PBField.initBool(false);
        this.str_web_conf_id = PBField.initString("");
        this.int32_info_type = PBField.initInt32(0);
        this.kuaibao_jump_url = PBField.initString("");
        this.kuaibao_jump_app_url = PBField.initString("");
        this.feeds_id = PBField.initUInt64(0L);
        this.comic_info = new MessageMicro<gallery$TComicInfo>() { // from class: tencent.im.oidb.gallery.gallery$TComicInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_chapter_cover;
            public final PBBytesField bytes_comic_status;
            public final PBBytesField bytes_comic_title;
            public final PBRepeatField<ByteStringMicro> rpt_bytes_comic_type;
            public final PBUInt32Field uint32_chapter_seqno;
            public final PBUInt32Field uint32_comic_id;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50}, new String[]{"bytes_comic_title", "rpt_bytes_comic_type", "bytes_comic_status", "uint32_chapter_seqno", "uint32_comic_id", "bytes_chapter_cover"}, new Object[]{byteStringMicro2, byteStringMicro2, byteStringMicro2, 0, 0, byteStringMicro2}, gallery$TComicInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_comic_title = PBField.initBytes(byteStringMicro2);
                this.rpt_bytes_comic_type = PBField.initRepeat(PBBytesField.__repeatHelper__);
                this.bytes_comic_status = PBField.initBytes(byteStringMicro2);
                this.uint32_chapter_seqno = PBField.initUInt32(0);
                this.uint32_comic_id = PBField.initUInt32(0);
                this.bytes_chapter_cover = PBField.initBytes(byteStringMicro2);
            }
        };
        this.bytes_publisher_head_url = PBField.initBytes(byteStringMicro);
        this.bytes_common_desc = PBField.initBytes(byteStringMicro);
        this.bytes_pos_ad_info = PBField.initBytes(byteStringMicro);
        this.bytes_ad_cookie = PBField.initBytes(byteStringMicro);
        this.bytes_debug = PBField.initBytes(byteStringMicro);
        this.recall_score = PBField.initDouble(0.0d);
        this.final_score = PBField.initDouble(0.0d);
        this.seq_id = PBField.initString("");
        this.read_to_next_rate = PBField.initDouble(0.0d);
        this.read_end_rate = PBField.initDouble(0.0d);
        this.read_wilson_score = PBField.initDouble(0.0d);
        this.quality_mean_score = PBField.initDouble(0.0d);
        this.first_pic_width = PBField.initUInt32(0);
        this.first_pic_height = PBField.initUInt32(0);
        this.social_info = new MessageMicro<gallery$SocialInfo>() { // from class: tencent.im.oidb.gallery.gallery$SocialInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint32_is_like", "uint32_like_count", "uint32_comments_count", "uint32_biu_count", "attach_comments"}, new Object[]{0, 0, 0, 0, null}, gallery$SocialInfo.class);
            public final PBUInt32Field uint32_is_like = PBField.initUInt32(0);
            public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
            public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
            public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
            public final PBRepeatMessageField<gallery$AttachComment> attach_comments = PBField.initRepeatMessage(gallery$AttachComment.class);
        };
    }
}

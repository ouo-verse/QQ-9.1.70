package tencent.im.oidb.cmd0xe33;

import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.view.FilterEnum;
import tencent.kandian.ugc.topic_info$TopicInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe33$ReqBody extends MessageMicro<oidb_0xe33$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"topic_info_set_req"}, new Object[]{null}, oidb_0xe33$ReqBody.class);
    public oidb_0xe33$TopicInfoSetReq topic_info_set_req = new MessageMicro<oidb_0xe33$TopicInfoSetReq>() { // from class: tencent.im.oidb.cmd0xe33.oidb_0xe33$TopicInfoSetReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"info", EntityManager.KEY_OPERATE_TYPE}, new Object[]{null, 0}, oidb_0xe33$TopicInfoSetReq.class);
        public topic_info$TopicInfo info = new MessageMicro<topic_info$TopicInfo>() { // from class: tencent.kandian.ugc.topic_info$TopicInfo
            static final MessageMicro.FieldMap __fieldMap__;

            /* renamed from: id, reason: collision with root package name */
            public final PBUInt32Field f436064id = PBField.initUInt32(0);
            public final PBStringField title = PBField.initString("");
            public final PBStringField intro = PBField.initString("");
            public final PBStringField cover_img = PBField.initString("");
            public final PBStringField icon_img = PBField.initString("");
            public final PBStringField pendant_img = PBField.initString("");
            public final PBUInt32Field type1 = PBField.initUInt32(0);
            public final PBUInt32Field type2 = PBField.initUInt32(0);
            public final PBUInt32Field type3 = PBField.initUInt32(0);
            public final PBUInt32Field create_time = PBField.initUInt32(0);
            public final PBStringField tags = PBField.initString("");
            public final PBUInt32Field source = PBField.initUInt32(0);
            public final PBUInt32Field status = PBField.initUInt32(0);
            public final PBUInt32Field ui_type = PBField.initUInt32(0);
            public final PBStringField cover_color = PBField.initString("");
            public final PBStringField video_url = PBField.initString("");
            public final PBUInt32Field topic_type = PBField.initUInt32(0);
            public final PBUInt32Field topic_valid = PBField.initUInt32(0);
            public final PBUInt64Field creator_uid = PBField.initUInt64(0);
            public final PBStringField rowkey = PBField.initString("");
            public final PBBoolField is_default = PBField.initBool(false);
            public final PBBoolField is_undistribute = PBField.initBool(false);
            public final PBUInt32Field audit_status = PBField.initUInt32(0);
            public final PBUInt32Field submit_permission = PBField.initUInt32(0);
            public final PBUInt64Field last_update_ts = PBField.initUInt64(0);
            public final PBUInt64Field version = PBField.initUInt64(0);
            public topic_info$TopicInfoExt ext = new MessageMicro<topic_info$TopicInfoExt>() { // from class: tencent.kandian.ugc.topic_info$TopicInfoExt
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBBoolField has_subscribe = PBField.initBool(false);
                public final PBRepeatMessageField<topic_info$ModuleInfo> modules = PBField.initRepeatMessage(topic_info$ModuleInfo.class);
                public final PBUInt32Field content_count = PBField.initUInt32(0);
                public final PBUInt32Field subscribe_num = PBField.initUInt32(0);
                public final PBStringField share_url = PBField.initString("");
                public final PBInt64Field algorithm_id = PBField.initInt64(0);
                public final PBBoolField is_top = PBField.initBool(false);
                public final PBUInt32Field topic_view = PBField.initUInt32(0);
                public final PBUInt32Field feeds_up_time = PBField.initUInt32(0);
                public final PBStringField feed_up_time_text = PBField.initString("");
                public final PBUInt32Field topic_feed_audit_status = PBField.initUInt32(0);
                public final PBUInt32Field comment_num = PBField.initUInt32(0);
                public final PBStringField creator_nickname = PBField.initString("");
                public final PBStringField creator_avatar_url = PBField.initString("");
                public final PBUInt32Field new_num = PBField.initUInt32(0);
                public final PBBoolField my_topic_flag = PBField.initBool(false);
                public final PBUInt32Field auditing_video_cnt = PBField.initUInt32(0);
                public final PBUInt32Field cooperator_cnt = PBField.initUInt32(0);
                public final PBRepeatMessageField<topic_info$CooperatorUser> lastest_cooperator_user = PBField.initRepeatMessage(topic_info$CooperatorUser.class);

                static {
                    String[] strArr = {QWalletMixJsPlugin.PARAMS_HAS_SUBSCRIBE, "modules", "content_count", "subscribe_num", GetGuildJoinUrlServlet.BUNDLE_KEY_URL, "algorithm_id", "is_top", "topic_view", "feeds_up_time", "feed_up_time_text", "topic_feed_audit_status", PictureConst.PHOTO_COMMENT_NUM, "creator_nickname", "creator_avatar_url", "new_num", "my_topic_flag", "auditing_video_cnt", "cooperator_cnt", "lastest_cooperator_user"};
                    Boolean bool = Boolean.FALSE;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48, 56, 64, 72, 82, 88, 96, 106, 114, 120, 128, 136, 144, 154}, strArr, new Object[]{bool, null, 0, 0, "", 0L, bool, 0, 0, "", 0, 0, "", "", 0, bool, 0, 0, null}, topic_info$TopicInfoExt.class);
                }
            };
            public final PBUInt32Field super_submit_permission = PBField.initUInt32(0);
            public final PBUInt32Field is_show_timestamp = PBField.initUInt32(0);
            public final PBUInt32Field payment_type = PBField.initUInt32(0);
            public topic_info$PaymentInfo payinfo = new MessageMicro<topic_info$PaymentInfo>() { // from class: tencent.kandian.ugc.topic_info$PaymentInfo
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBUInt32Field update_status = PBField.initUInt32(0);
                public final PBUInt32Field plan_content_count = PBField.initUInt32(0);
                public final PBFloatField current_price = PBField.initFloat(0.0f);
                public final PBFloatField original_price = PBField.initFloat(0.0f);
                public final PBUInt64Field discount_start_time = PBField.initUInt64(0);
                public final PBUInt64Field discount_end_time = PBField.initUInt64(0);
                public final PBBoolField sale_flag = PBField.initBool(false);

                static {
                    Float valueOf = Float.valueOf(0.0f);
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 29, 37, 40, 48, 56}, new String[]{"update_status", "plan_content_count", "current_price", "original_price", "discount_start_time", "discount_end_time", "sale_flag"}, new Object[]{0, 0, valueOf, valueOf, 0L, 0L, Boolean.FALSE}, topic_info$PaymentInfo.class);
                }
            };
            public final PBUInt32Field sort_type = PBField.initUInt32(0);
            public final PBBoolField is_high_quality = PBField.initBool(false);

            static {
                int[] iArr = {8, 18, 26, 34, 42, 50, 56, 64, 72, 80, 90, 96, 104, 120, 130, 138, 144, 152, 160, 170, 176, 184, 192, 200, 208, 216, 242, 248, 256, 264, 274, FilterEnum.MIC_PTU_TRANS_XINXIAN, 288};
                String[] strArr = {"id", "title", "intro", "cover_img", "icon_img", "pendant_img", "type1", "type2", "type3", AlbumCacheData.CREATE_TIME, ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "source", "status", "ui_type", "cover_color", "video_url", "topic_type", "topic_valid", "creator_uid", "rowkey", "is_default", "is_undistribute", "audit_status", "submit_permission", "last_update_ts", "version", "ext", "super_submit_permission", "is_show_timestamp", "payment_type", "payinfo", "sort_type", "is_high_quality"};
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{0, "", "", "", "", "", 0, 0, 0, 0, "", 0, 0, 0, "", "", 0, 0, 0L, "", bool, bool, 0, 0, 0L, 0L, null, 0, 0, 0, null, 0, bool}, topic_info$TopicInfo.class);
            }
        };
        public final PBUInt32Field operate_type = PBField.initUInt32(0);
    };
}

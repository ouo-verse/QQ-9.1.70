package qzone;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$RankingPageRsp extends MessageMicro<QzoneActivityPB$RankingPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public QzoneActivityPB$UserPageInfo self = new QzoneActivityPB$UserPageInfo();
    public QzoneActivityPB$UserPageInfo first = new QzoneActivityPB$UserPageInfo();
    public QzoneActivityPB$PopWindowInfo pop_window_info = new MessageMicro<QzoneActivityPB$PopWindowInfo>() { // from class: qzone.QzoneActivityPB$PopWindowInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"text", "sub_text", "pic", "jump_url", "backgroud", "display_cfg"}, new Object[]{"", "", "", "", "", null}, QzoneActivityPB$PopWindowInfo.class);
        public final PBStringField text = PBField.initString("");
        public final PBStringField sub_text = PBField.initString("");
        public final PBStringField pic = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
        public final PBStringField backgroud = PBField.initString("");
        public QzoneActivityPB$DisplayCfg display_cfg = new QzoneActivityPB$DisplayCfg();
    };
    public final PBRepeatMessageField<QzoneActivityPB$PKInfo> pk_infos = PBField.initRepeatMessage(QzoneActivityPB$PKInfo.class);
    public final PBRepeatMessageField<QzoneActivityPB$UserPageInfo> ranks = PBField.initRepeatMessage(QzoneActivityPB$UserPageInfo.class);
    public final PBStringField cookie = PBField.initString("");
    public final PBBoolField is_end = PBField.initBool(false);
    public final PBBoolField task_flexible = PBField.initBool(false);
    public final PBBoolField ranking_flexible = PBField.initBool(false);
    public final PBBoolField is_dragon_activity_end = PBField.initBool(false);

    static {
        String[] strArr = {"self", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "pop_window_info", "pk_infos", "ranks", "cookie", "is_end", "task_flexible", "ranking_flexible", "is_dragon_activity_end"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 72, 80}, strArr, new Object[]{null, null, null, null, null, "", bool, bool, bool, bool}, QzoneActivityPB$RankingPageRsp.class);
    }
}

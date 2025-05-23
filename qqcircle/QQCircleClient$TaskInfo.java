package qqcircle;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleClient$TaskInfo extends MessageMicro<QQCircleClient$TaskInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 64, 74, 82, 400, 408, 416, 424}, new String[]{"id", "title", "icon", "desc", "tips", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "upper_count", "reward_count", "botton_text", "jump_url", "status", "done_count", "available_reward", "done_step"}, new Object[]{0, "", "", "", "", "", 0, 0, "", "", 0, 0, 0, 0}, QQCircleClient$TaskInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f429295id = PBField.initUInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField tips = PBField.initString("");
    public final PBRepeatField<String> tags = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field upper_count = PBField.initUInt32(0);
    public final PBUInt32Field reward_count = PBField.initUInt32(0);
    public final PBStringField botton_text = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBEnumField status = PBField.initEnum(0);
    public final PBUInt32Field done_count = PBField.initUInt32(0);
    public final PBUInt32Field available_reward = PBField.initUInt32(0);
    public final PBUInt32Field done_step = PBField.initUInt32(0);
}

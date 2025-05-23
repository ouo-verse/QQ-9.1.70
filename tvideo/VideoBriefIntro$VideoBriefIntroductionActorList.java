package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class VideoBriefIntro$VideoBriefIntroductionActorList extends MessageMicro<VideoBriefIntro$VideoBriefIntroductionActorList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "actor_list"}, new Object[]{"", null}, VideoBriefIntro$VideoBriefIntroductionActorList.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<VideoBriefIntro$Star> actor_list = PBField.initRepeatMessage(VideoBriefIntro$Star.class);
}

package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YesGameInfoOuterClass$GameConfigOfMicCard extends MessageMicro<YesGameInfoOuterClass$GameConfigOfMicCard> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"color_mic_item_nick_name", "icon_mic_empty", "icon_mic_apply_entrance"}, new Object[]{"", "", ""}, YesGameInfoOuterClass$GameConfigOfMicCard.class);
    public final PBStringField color_mic_item_nick_name = PBField.initString("");
    public final PBStringField icon_mic_empty = PBField.initString("");
    public final PBStringField icon_mic_apply_entrance = PBField.initString("");
}

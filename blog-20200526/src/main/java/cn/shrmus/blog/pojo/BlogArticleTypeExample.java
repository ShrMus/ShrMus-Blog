package cn.shrmus.blog.pojo;

import java.util.ArrayList;
import java.util.List;

public class BlogArticleTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogArticleTypeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andArticleTypeIdIsNull() {
            addCriterion("article_type_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdIsNotNull() {
            addCriterion("article_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdEqualTo(Integer value) {
            addCriterion("article_type_id =", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdNotEqualTo(Integer value) {
            addCriterion("article_type_id <>", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdGreaterThan(Integer value) {
            addCriterion("article_type_id >", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_type_id >=", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdLessThan(Integer value) {
            addCriterion("article_type_id <", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_type_id <=", value, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdIn(List<Integer> values) {
            addCriterion("article_type_id in", values, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdNotIn(List<Integer> values) {
            addCriterion("article_type_id not in", values, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("article_type_id between", value1, value2, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_type_id not between", value1, value2, "articleTypeId");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameIsNull() {
            addCriterion("article_type_name is null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameIsNotNull() {
            addCriterion("article_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameEqualTo(String value) {
            addCriterion("article_type_name =", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameNotEqualTo(String value) {
            addCriterion("article_type_name <>", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameGreaterThan(String value) {
            addCriterion("article_type_name >", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("article_type_name >=", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameLessThan(String value) {
            addCriterion("article_type_name <", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameLessThanOrEqualTo(String value) {
            addCriterion("article_type_name <=", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameLike(String value) {
            addCriterion("article_type_name like", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameNotLike(String value) {
            addCriterion("article_type_name not like", value, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameIn(List<String> values) {
            addCriterion("article_type_name in", values, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameNotIn(List<String> values) {
            addCriterion("article_type_name not in", values, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameBetween(String value1, String value2) {
            addCriterion("article_type_name between", value1, value2, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNameNotBetween(String value1, String value2) {
            addCriterion("article_type_name not between", value1, value2, "articleTypeName");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionIsNull() {
            addCriterion("article_type_description is null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionIsNotNull() {
            addCriterion("article_type_description is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionEqualTo(String value) {
            addCriterion("article_type_description =", value, "articleTypeDescription");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionNotEqualTo(String value) {
            addCriterion("article_type_description <>", value, "articleTypeDescription");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionGreaterThan(String value) {
            addCriterion("article_type_description >", value, "articleTypeDescription");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("article_type_description >=", value, "articleTypeDescription");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionLessThan(String value) {
            addCriterion("article_type_description <", value, "articleTypeDescription");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionLessThanOrEqualTo(String value) {
            addCriterion("article_type_description <=", value, "articleTypeDescription");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionLike(String value) {
            addCriterion("article_type_description like", value, "articleTypeDescription");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionNotLike(String value) {
            addCriterion("article_type_description not like", value, "articleTypeDescription");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionIn(List<String> values) {
            addCriterion("article_type_description in", values, "articleTypeDescription");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionNotIn(List<String> values) {
            addCriterion("article_type_description not in", values, "articleTypeDescription");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionBetween(String value1, String value2) {
            addCriterion("article_type_description between", value1, value2, "articleTypeDescription");
            return (Criteria) this;
        }

        public Criteria andArticleTypeDescriptionNotBetween(String value1, String value2) {
            addCriterion("article_type_description not between", value1, value2, "articleTypeDescription");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
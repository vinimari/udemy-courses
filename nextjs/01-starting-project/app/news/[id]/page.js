export default function DynamicNews({ params }) {
  const newsId = params.id;
  return (
    <>
      <h1>News Detail Page</h1>
      <p>My news ID is: {newsId}</p>
    </>
  );
}
